package net.kzeroko.isekaiweaponryfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kzeroko.isekaiweaponryfabric.config.MidnightConfig;
import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiSounds;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiWeapons;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IsekaiweaponryFabric implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("isekaiweaponryfabric");
	public static final String MOD_ID = "isekaiweaponryfabric";

	// INIT
	@Override
	public void onInitialize() {
		MidnightConfig.init("isekaiweaponryfabric", MidnightConfigConstructor.class);
		IsekaiWeapons.init();
		IsekaiSounds.init();
		LOGGER.info("IsekaiWeaponry is initializing!");
	}

	// Groups
	public static final ItemGroup WEAPONS = FabricItemGroupBuilder.build(new Identifier("isekaiweaponryfabric", "weapons"), () -> {
		return new ItemStack(IsekaiWeapons.KISARAS_DEVILSWORD);
	});

}
