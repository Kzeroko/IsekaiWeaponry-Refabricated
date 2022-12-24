package net.kzeroko.isekaiweaponryfabric;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IsekaiUtils {

    public static Identifier ID(String id) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, id);
    }

    public static <I extends Item> I registerItem(I item, String name) {
        return (I) Registry.register(Registry.ITEM, new Identifier("isekaiweaponryfabric", name), item);
    }
}
