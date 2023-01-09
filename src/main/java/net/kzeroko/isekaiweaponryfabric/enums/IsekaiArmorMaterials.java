package net.kzeroko.isekaiweaponryfabric.enums;

import java.util.function.Supplier;

import net.kzeroko.isekaiweaponryfabric.init.IsekaiSounds;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum IsekaiArmorMaterials implements ArmorMaterial {
    PROSTHETIC_ARMCOAT("prosthetic_armcoat", 150, new int[]{6, 12, 24, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 15.0F, 0.5F, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    KISARASDEMONSET("kisarasdemonset", 120, new int[]{4, 12, 18, 5}, 10, IsekaiSounds.CAST_DARK, 10.0F, 0.2F, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    NETHERITE1("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    });

    private static final int[] BASE_DURABILITY = new int[]{20, 20, 20, 20};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private IsekaiArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
