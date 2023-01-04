package net.kzeroko.isekaiweaponryfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kzeroko.isekaiweaponryfabric.config.MidnightConfig;
import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
import net.kzeroko.isekaiweaponryfabric.init.*;
import net.kzeroko.isekaiweaponryfabric.network.PacketReg;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class IsekaiweaponryFabric implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("isekaiweaponryfabric");
	public static final String MOD_ID = "isekaiweaponryfabric";
	public static IsekaiEntities ENTITIES;
	public static final Identifier DONNER = new Identifier(MOD_ID, "donner");
	public static final Identifier SCHLAG = new Identifier(MOD_ID, "schlag");

	// INIT
	@Override
	public void onInitialize() {
		LOGGER.info("IsekaiWeaponry is initializing!");
		MidnightConfig.init(IsekaiweaponryFabric.MOD_ID, MidnightConfigConstructor.class);
		IsekaiWeapons.init();
		IsekaiRangeWeapons.init();
		IsekaiMiscItems.init();
		IsekaiArmors.init();
		IsekaiSounds.init();
		IsekaiEffects.init();
		ENTITIES = new IsekaiEntities();
		GeckoLib.initialize();
		PacketReg.registerMessages();
	}

	// Groups
	public static final ItemGroup WEAPONS = FabricItemGroupBuilder.build(new Identifier("isekaiweaponryfabric", "weapons"), () -> {
		return new ItemStack(IsekaiWeapons.PAN_DORAL);
	});
	public static final ItemGroup RANGEWEAPONS = FabricItemGroupBuilder.build(new Identifier("isekaiweaponryfabric", "rangeweapons"), () -> {
		return new ItemStack(IsekaiRangeWeapons.DONNER);
	});
	public static final ItemGroup MISCITEMS = FabricItemGroupBuilder.build(new Identifier("isekaiweaponryfabric", "miscitems"), () -> {
		return new ItemStack(IsekaiMiscItems.ALLOYED_BULLETS);
	});

}
