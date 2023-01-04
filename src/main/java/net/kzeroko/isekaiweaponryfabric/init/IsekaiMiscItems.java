package net.kzeroko.isekaiweaponryfabric.init;

import net.kzeroko.isekaiweaponryfabric.IsekaiUtils;
import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class IsekaiMiscItems {
    public static final ItemGroup MISCITEMS;
    public static final Item ALLOYED_BULLETS;
    public static final Item ALLOYED_BULLET;

    public IsekaiMiscItems() {
    }

    public static void init() {
        IsekaiUtils.registerItem(ALLOYED_BULLETS, "alloyed_bullets");
        IsekaiUtils.registerItem(ALLOYED_BULLET, "alloyed_bullet");
    }

    static {
        MISCITEMS = IsekaiweaponryFabric.MISCITEMS;
        ALLOYED_BULLETS = new Item((new Item.Settings().group(MISCITEMS).rarity(Rarity.EPIC).maxCount(16)));
        ALLOYED_BULLET = new Item((new Item.Settings().group(MISCITEMS).rarity(Rarity.EPIC).maxCount(64)));
    }
}

