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

package xyz.mrcraftteammc.mrcraftessentials.annotations;

import net.minecraft.util.annotation.FieldsAreNonnullByDefault;
import net.minecraft.util.annotation.MathMethodsReturnNonnullByDefault;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@FieldsAreNonnullByDefault
@MethodsReturnNonnullByDefault
@MathMethodsReturnNonnullByDefault
@NotNull
@SuppressWarnings("unused")
@Retention(RetentionPolicy.RUNTIME)
public @interface Noop {
}
