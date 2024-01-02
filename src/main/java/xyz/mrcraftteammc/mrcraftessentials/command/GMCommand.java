/*
 * This file is part of the MrCraftEssentialsMod project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  MrCraftTeamMC and contributors
 *
 * MrCraftEssentialsMod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MrCraftEssentialsMod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MrCraftEssentialsMod.  If not, see <https://www.gnu.org/licenses/>.
 */

package xyz.mrcraftteammc.mrcraftessentials.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import xyz.mrcraftteammc.mrcraftessentials.ModSettingManager;

public abstract class GMCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        final LiteralCommandNode<ServerCommandSource> gamemode = dispatcher.register(CommandManager.literal("gm")
                .requires(source -> Permissions.check(source, "rfe.command.gm", 0))
                .executes(context -> execute(context.getSource())));
    }

    public static int execute(ServerCommandSource source) throws CommandSyntaxException {
        // TODO Fix Bugs
        ServerPlayerInteractionManager player = source.getPlayerOrThrow().interactionManager;
//        ServerWorld world = source.getWorld();
//        MinecraftServer server = source.getServer();

        String modename = "";

        if (player.getGameMode() == GameMode.SURVIVAL) {
            player.changeGameMode(GameMode.SPECTATOR);
            modename = Text.translatable("gameMode.spectator").getString();
        } else if (player.getGameMode() == GameMode.SPECTATOR || player.getGameMode() == GameMode.CREATIVE) {
            player.changeGameMode(GameMode.SURVIVAL);
            modename = Text.translatable("gameMode.survival").getString();
        }

        final Text feedback = Text.translatable("commands.gm.feedback", modename).formatted(ModSettingManager.COMMAND_FEEDBACK_BASE_COLOR);

        source.sendFeedback(() -> feedback, false);

        return Command.SINGLE_SUCCESS;
    }
}
