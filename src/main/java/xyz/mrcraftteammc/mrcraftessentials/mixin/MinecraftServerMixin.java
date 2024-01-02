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

package xyz.mrcraftteammc.mrcraftessentials.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
	@Inject(
			method = "loadWorld",
			at = @At("HEAD")
	)
	private void onLoadWorld(CallbackInfo ci) {
//		LogUtils.getLogger().info("{} mod is loading for world!", MrCraftEssentialsMod.MOD_NAME);
	}

	@Inject(
			method = "runServer",
			at = @At("HEAD")
	)
	private void onRunServer(CallbackInfo ci) {
//		LogUtils.getLogger().info("{} mod is loading! version: {}", MrCraftEssentialsMod.MOD_NAME, MrCraftEssentialsMod.MOD_VERSION);
	}

	@Inject(
			method = "shutdown",
			at = @At("HEAD")
	)
	private void onShutdown(CallbackInfo ci) {
//		LogUtils.getLogger().info("{} mod is shutting down!", MrCraftEssentialsMod.MOD_NAME);
	}
}