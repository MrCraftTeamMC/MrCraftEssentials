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
import lombok.Getter;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import xyz.mrcraftteammc.mrcraftessentials.ModSettingManager;

public abstract class EssentialTimeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        final LiteralCommandNode<ServerCommandSource> day = dispatcher.register(CommandManager.literal("day")
                .requires(source -> Permissions.check(source, "rfe.command.time", 2))
                .executes(context -> execute(context.getSource(), TimeFlag.DAY)));

        final LiteralCommandNode<ServerCommandSource> noon = dispatcher.register(CommandManager.literal("noon")
                .requires(source -> Permissions.check(source, "rfe.command.time", 2))
                .executes(context -> execute(context.getSource(), TimeFlag.NOON)));

        final LiteralCommandNode<ServerCommandSource> night = dispatcher.register(CommandManager.literal("night")
                .requires(source -> Permissions.check(source, "rfe.command.time", 2))
                .executes(context -> execute(context.getSource(), TimeFlag.NIGHT)));

        final LiteralCommandNode<ServerCommandSource> midnight = dispatcher.register(CommandManager.literal("midnight")
                .requires(source -> Permissions.check(source, "rfe.command.time", 2))
                .executes(context -> execute(context.getSource(), TimeFlag.MIDNIGHT)));
    }

    public static int execute(ServerCommandSource source, TimeFlag time) {
        ServerWorld world = source.getWorld();
//        ServerPlayerEntity player = source.getPlayerOrThrow();
        int tick = time.getTick();
        final Text feedback = time.getText();

        world.setTimeOfDay(tick);
        source.sendFeedback(() -> feedback, false);

        return Command.SINGLE_SUCCESS;
    }

    @Getter
    public enum TimeFlag {
        DAY(1000, "commands.esstime.day.name"),
        NOON(6000, "commands.esstime.noon.name"),
        NIGHT(13000, "commands.esstime.night.name"),
        MIDNIGHT(18000, "commands.esstime.midnight.name");

        private final int tick;
        private final Text text;

        private TimeFlag(int tick, String key) {
            this.tick = tick;
            this.text = Text.translatable(key).formatted(ModSettingManager.COMMAND_FEEDBACK_BASE_COLOR);
        }
    }
}
