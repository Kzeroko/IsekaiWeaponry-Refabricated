package net.kzeroko.isekaiweaponryfabric.init;

import net.kzeroko.isekaiweaponryfabric.IsekaiUtils;
import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.enums.IsekaiArmorMaterials;
import net.kzeroko.isekaiweaponryfabric.item.armor.KisarasDemonset;
import net.kzeroko.isekaiweaponryfabric.item.armor.ProstheticArmcoat;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;

public class IsekaiArmors {
    public static final ItemGroup MISCITEMS;
    public static final ArmorItem PROSTHETIC_ARMCOAT;
    public static final ArmorItem KISARASDEMONSET_HEAD;
    public static final ArmorItem KISARASDEMONSET_CHEST;

    public IsekaiArmors() {
    }

    public static void init() {
        IsekaiUtils.registerItem(PROSTHETIC_ARMCOAT, "prosthetic_armcoat");
        IsekaiUtils.registerItem(KISARASDEMONSET_HEAD, "kisarasdemonset_head");
        IsekaiUtils.registerItem(KISARASDEMONSET_CHEST, "kisarasdemonset_chest");
    }

    static {
        MISCITEMS = IsekaiweaponryFabric.MISCITEMS;
        PROSTHETIC_ARMCOAT = new ProstheticArmcoat(IsekaiArmorMaterials.PROSTHETIC_ARMCOAT, EquipmentSlot.CHEST, new Item.Settings().group(MISCITEMS).rarity(Rarity.EPIC));
        KISARASDEMONSET_HEAD = new KisarasDemonset(IsekaiArmorMaterials.KISARASDEMONSET, EquipmentSlot.HEAD, new Item.Settings().group(MISCITEMS).rarity(Rarity.EPIC));
        KISARASDEMONSET_CHEST = new KisarasDemonset(IsekaiArmorMaterials.KISARASDEMONSET, EquipmentSlot.CHEST, new Item.Settings().group(MISCITEMS).rarity(Rarity.EPIC));
    }
}

