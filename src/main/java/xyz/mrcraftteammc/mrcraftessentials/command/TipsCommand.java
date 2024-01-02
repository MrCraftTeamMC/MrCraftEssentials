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
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import xyz.mrcraftteammc.mrcraftessentials.ModSettingManager;

import java.util.List;
import java.util.Random;

public abstract class TipsCommand {
    private static final Random random = new Random();

    public static final List<String> TIPS = List.of(
            "commands.tips.tip1",
            "commands.tips.tip2"
    );

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        final LiteralCommandNode<ServerCommandSource> tips = dispatcher.register(CommandManager.literal("tips")
                .requires(source -> Permissions.check(source, "rfe.command.tips", 0))
                .executes(context -> execute(context.getSource())));
    }

    public static int execute(ServerCommandSource source) {
        int orindal = random.nextInt(TIPS.size());
        final Text feedbackFirst = Text.translatable("commands.tips.feedback").formatted(ModSettingManager.COMMAND_FEEDBACK_BASE_COLOR);

        source.sendFeedback(() -> feedbackFirst, false);

        try {
            final Text feedback = Text.translatable(TIPS.get(orindal));
            source.sendFeedback(() -> feedback, false);

        } catch (ArrayIndexOutOfBoundsException e1) {
            source.sendFeedback(() -> Text.translatable("commands.tips.fail"), false);
        }

        return Command.SINGLE_SUCCESS;
    }
}
