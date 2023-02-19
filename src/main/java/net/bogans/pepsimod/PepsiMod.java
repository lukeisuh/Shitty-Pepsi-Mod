package net.bogans.pepsimod;

import net.fabricmc.api.ModInitializer;

import net.bogans.pepsimod.item.ModItemGroup;
import net.bogans.pepsimod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class PepsiMod implements ModInitializer {
	public static final String MOD_ID = "pepsimod";
	public static final Logger LOGGER = LoggerFactory.getLogger("pepsimod");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
	}
}