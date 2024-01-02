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
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.Vec3d;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class BackCommand {
    private final Map<String, List<Vec3d>> PositionPointsMap = new LinkedHashMap<>();

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        /*
         final LiteralCommandNode<ServerCommandSource> back = dispatcher.register(CommandManager.literal("back")
                 .then(CommandManager.argument("name", StringArgumentType.string())
                         .requires(source -> ((ServerCommandSource) source).hasPermissionLevel(2))
                         .executes(context -> {
                             ServerPlayerEntity player = context.getSource().getPlayerOrThrow();


                             return 0;
                         })));
         */
        final LiteralCommandNode<ServerCommandSource> back = dispatcher.register(CommandManager.literal("back"));
    }

    public static int execute() {
        return Command.SINGLE_SUCCESS;
    }
}
