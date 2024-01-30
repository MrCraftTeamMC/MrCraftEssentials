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

package xyz.mrcraftteammc.mrcraftessentials;

import net.minecraft.util.Formatting;

public class ModSettingManager {
    public static Formatting COMMAND_FEEDBACK_BASE_COLOR = Formatting.GOLD;
    public static Formatting COMMAND_FEEDBACK_HIGHLIGHT_COLOR = Formatting.RED;
    public static Formatting COMMAND_FEEDBACK_ANOTHER_BASE_COLOR = Formatting.GREEN;

    public ModSettingManager() {
    }
}
