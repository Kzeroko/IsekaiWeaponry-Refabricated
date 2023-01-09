package net.kzeroko.isekaiweaponryfabric.init;

import net.kzeroko.isekaiweaponryfabric.IsekaiUtils;
import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.item.weapon.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class IsekaiRangeWeapons {
    public static final ItemGroup RANGEWEAPONS;
    public static Item DONNER;
    public static Item SCHLAG;

    public IsekaiRangeWeapons() {
    }

    public static void init() {
        IsekaiUtils.registerItem(DONNER, "donner");
        IsekaiUtils.registerItem(SCHLAG, "schlag");
    }

    static {
        RANGEWEAPONS = IsekaiweaponryFabric.RANGEWEAPONS;
        DONNER = new Donner(-1,-2.4F, new Item.Settings().maxCount(1).maxDamage(7).group(IsekaiweaponryFabric.RANGEWEAPONS).rarity(Rarity.EPIC).fireproof());
        SCHLAG = new Schlag(-1,-2.4F, new Item.Settings().maxCount(1).maxDamage(7).group(IsekaiweaponryFabric.RANGEWEAPONS).rarity(Rarity.EPIC).fireproof());
    }
}

