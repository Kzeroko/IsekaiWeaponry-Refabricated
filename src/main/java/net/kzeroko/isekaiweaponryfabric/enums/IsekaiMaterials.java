package net.kzeroko.isekaiweaponryfabric.enums;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import java.util.function.Supplier;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum IsekaiMaterials implements ToolMaterial {
    OVERLORD(0, 4000, 0.0F, 0.0F, 25, () -> {
        return Ingredient.ofItems(Items.AIR);
        /* return Ingredient.fromTag(ItemTags.PLANKS); */
    }),
    ASTERISK(0, 2300, 0.0F, 0.0F, 20, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    SAO(0, 2500, 0.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    RWBY(0, 1900, 0.0F, 0.0F, 15, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    MGRR(0, 2100, 0.0F, 0.0F, 12, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    ENGAGEKISS(0, 3000, 0.0F, 0.0F, 15, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    SHADOW(0, 3500, 0.0F, 0.0F, 25, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    OJISAN(0, 2700, 0.0F, 0.0F, 18, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    XENOBLADE(0, 2000, 0.0F, 0.0F, 21, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    ORIGAMI(0, 1800, 0.0F, 0.0F, 21, () -> {
        return Ingredient.ofItems(Items.AIR);
    }),
    DAL(0, 2600, 0.0F, 0.0F, 25, () -> {
        return Ingredient.ofItems(Items.AIR);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private IsekaiMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}