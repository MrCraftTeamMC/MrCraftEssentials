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
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import xyz.mrcraftteammc.mrcraftessentials.ModSettingManager;

public abstract class ReloadCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        final LiteralCommandNode<ServerCommandSource> reload = dispatcher.register(CommandManager.literal("reload")
                .requires(source -> Permissions.check(source, "rfe.command.reload", 0))
                .then(CommandManager.literal("command")
                        .executes(context -> execute_reloadCommand(context.getSource()))));
    }

    public static int execute_reloadCommand(ServerCommandSource source) throws CommandSyntaxException {
        MinecraftServer server = source.getServer();
        ServerPlayerEntity player = source.getPlayerOrThrow();

        final Text feedback_before = Text.translatable("commands.reload.command.feedback.before").formatted(ModSettingManager.COMMAND_FEEDBACK_BASE_COLOR);
        final Text feedback_after = Text.translatable("commands.reload.command.feedback.after").formatted(ModSettingManager.COMMAND_FEEDBACK_BASE_COLOR);

        source.sendFeedback(() -> feedback_before, true);

        server.getPlayerManager().sendCommandTree(player);
        source.sendFeedback(() -> feedback_after, true);

        return Command.SINGLE_SUCCESS;
    }
}
