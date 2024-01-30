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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import xyz.mrcraftteammc.mrcraftessentials.ModSettingManager;

public abstract class HereCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        final LiteralCommandNode<ServerCommandSource> here = dispatcher.register(CommandManager.literal("here")
                .requires(source -> Permissions.check(source, "rfe.command.here", 0))
                .executes(context -> execute(context.getSource())));
    }

    public static int execute(ServerCommandSource source) throws CommandSyntaxException {
        MinecraftServer server = source.getServer();
        ServerPlayerEntity player = source.getPlayerOrThrow();
        ServerWorld world = player.getServerWorld();
        Vec3d pos = player.getPos();

        String worldName = "";

        if (world.getRegistryKey() == World.END) {
            worldName = Text.translatable("dimensions.end").getString();
        } else if (world.getRegistryKey() == World.NETHER) {
            worldName = Text.translatable("dimensions.nether").getString();
        } else if (world.getRegistryKey() == World.OVERWORLD) {
            worldName = Text.translatable("dimensions.overworld").getString();
        } else {
            return 1;
        }

        final Text feedback = Text.translatable("commands.here.feedback", player.getName().getString(), pos.x, pos.y, pos.z, worldName).formatted(ModSettingManager.COMMAND_FEEDBACK_ANOTHER_BASE_COLOR);

        server.getPlayerManager().broadcast(feedback, false);

        return Command.SINGLE_SUCCESS;
    }
}
