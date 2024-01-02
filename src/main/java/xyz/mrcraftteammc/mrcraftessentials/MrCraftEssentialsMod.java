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

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import xyz.mrcraftteammc.mrcraftessentials.annotations.Noop;
import xyz.mrcraftteammc.mrcraftessentials.command.*;
import xyz.mrcraftteammc.mrcraftessentials.util.LoaderUtils;

public class MrCraftEssentialsMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("Fabricated-Essentials");
	public static final String MOD_ID = "fabricated-essentials";
	public static final String MOD_NAME = "FabricatedEssentials";
	public static final String MOD_VERSION = LoaderUtils.getMod(MOD_ID).getMetadata().getVersion().getFriendlyString();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		registerCommands();
	}

	/*
	public static void registerEvent() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			ServerPlayerEntity player = handler.player;
		});
	}
	 */

	public static void registerCommands() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
//			AdvancedBlackList
//			AdvancedWhiteList
			AfkCommand.register(dispatcher);
//			BanCommand
//			BanIpCommand
			BackCommand.register(dispatcher);
			BroadCastCommand.register(dispatcher);
			ChatCommand.register(dispatcher);
			DimCommand.register(dispatcher);
			EssentialTimeCommand.register(dispatcher);
			GMCommand.register(dispatcher);
//			HelpCommand
			HereCommand.register(dispatcher);
			HomeCommand.register(dispatcher);
			KickAllCommand.register(dispatcher);
			LuckyCommand.register(dispatcher);
			MotdCommand.register(dispatcher);
			ReloadCommand.register(dispatcher);
			SuicideCommand.register(dispatcher);
			TeleportCommand.register(dispatcher);
			TipsCommand.register(dispatcher);
			VoteCommand.register(dispatcher);
			WarpCommand.register(dispatcher);
		});
	}
}