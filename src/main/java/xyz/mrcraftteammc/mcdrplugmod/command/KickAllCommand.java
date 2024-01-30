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
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import xyz.mrcraftteammc.mrcraftessentials.ModSettingManager;

public abstract class KickAllCommand {
    // TODO 增加倒计时

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        final LiteralCommandNode<ServerCommandSource> kickall = dispatcher.register(CommandManager.literal("kickall")
                .requires(source -> Permissions.check(source, "rfe.command.kickall", 4))
                .executes(context -> execute(context.getSource())));
    }

    public static int execute(ServerCommandSource source) throws CommandSyntaxException {
//        ServerWorld world = source.getWorld();
//        ServerPlayerEntity player = source.getPlayerOrThrow();
        MinecraftServer server = source.getServer();

        final Text feedback = Text.translatable("commands.kickAll.feedback").formatted(ModSettingManager.COMMAND_FEEDBACK_BASE_COLOR);

        source.sendFeedback(() -> feedback, true);
        server.getPlayerManager().disconnectAllPlayers();  // TODO: 更改 disconnect 的 Text

        return Command.SINGLE_SUCCESS;
    }
}
