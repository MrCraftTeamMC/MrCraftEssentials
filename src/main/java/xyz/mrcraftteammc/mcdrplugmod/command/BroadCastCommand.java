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
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.command.argument.ColorArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public abstract class BroadCastCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        /*
        final LiteralCommandNode<ServerCommandSource> broadcast = dispatcher.register(CommandManager.literal("broadcast")
                .then(CommandManager.argument("message", StringArgumentType.greedyString())
                        .executes(context -> execute(context.getSource(), StringArgumentType.getString(context, "message"), Formatting.WHITE)))

                .then(CommandManager.argument("message", StringArgumentType.greedyString())
                        .then(CommandManager.argument("color", ColorArgumentType.color())
                                .executes(context -> execute(context.getSource(), StringArgumentType.getString(context, "message"), ColorArgumentType.getColor(context, "color"))))));
        */
        final LiteralCommandNode<ServerCommandSource> broadcast = dispatcher.register(CommandManager.literal("broadcast")
                .requires(source -> Permissions.check(source, "rfe.command.broadcast", 2))
                .then(CommandManager.argument("color", ColorArgumentType.color())
                        .then(CommandManager.argument("message", StringArgumentType.greedyString())
                                .executes(context -> execute(context.getSource(), ColorArgumentType.getColor(context, "color"), StringArgumentType.getString(context, "message")))))

                .then(CommandManager.argument("message", StringArgumentType.greedyString())
                        .executes(context -> execute(context.getSource(), Formatting.WHITE, StringArgumentType.getString(context, "message")))));
    }

    public static int execute(ServerCommandSource source, Formatting formatting, String message) throws CommandSyntaxException {
//        ServerPlayerEntity player = source.getPlayerOrThrow();
        final Text text = Text.literal("[广播] " + message).formatted(formatting);
        // feedback 成功发送广播

        source.getServer().getPlayerManager().broadcast(text, false);
//        source.sendFeedback(() -> text, true);

        return Command.SINGLE_SUCCESS;
    }
}
