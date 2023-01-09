package net.kzeroko.isekaiweaponryfabric.init;

import net.kzeroko.isekaiweaponryfabric.IsekaiUtils;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class IsekaiEffects {
    public static final StatusEffect TENJU;
    public static final StatusEffect PANDORAS_VISION;
    public static final StatusEffect PANDORAS_DANCE;
    public static final StatusEffect ENHANCED_STRENGTH;
    public static final StatusEffect DEMONIC_POWER;

    public IsekaiEffects() {
    }

    public static void init() {
        IsekaiUtils.registerEffect(TENJU, "tenju");
        IsekaiUtils.registerEffect(PANDORAS_VISION, "pandoras_vision");
        IsekaiUtils.registerEffect(PANDORAS_DANCE, "pandoras_dance");
        IsekaiUtils.registerEffect(ENHANCED_STRENGTH, "enhanced_strength");
        IsekaiUtils.registerEffect(DEMONIC_POWER, "demonic_power");
    }

    static {
        TENJU = new NormStatusEffect(StatusEffectCategory.BENEFICIAL, 11796479)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AA9A0525-A197-4323-AB75-C640F65511ED", 0.25, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "787EABF1-418B-4415-B6A4-99E41B9CAB3E", 3.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, "58EDC562-7AD6-4327-BBFD-4729611F5A5D", 3.5, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "F9438A1C-F49C-4C78-9CD7-64724007F9A6", 7.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "0A43554D-451B-4B09-99EB-D404D35B9088", 10.0, EntityAttributeModifier.Operation.ADDITION);
        PANDORAS_VISION = new NormStatusEffect(StatusEffectCategory.BENEFICIAL, 11796479)
                .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "D0B3EB98-FD96-4ED4-A0CB-6B3B37D1638E", 0.03, EntityAttributeModifier.Operation.ADDITION);
        PANDORAS_DANCE = new NormStatusEffect(StatusEffectCategory.BENEFICIAL, 11796479)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "C7AF319B-1F5E-4A02-92DA-2069382F838B", 0.15, EntityAttributeModifier.Operation.ADDITION);
        ENHANCED_STRENGTH = new NormStatusEffect(StatusEffectCategory.BENEFICIAL, 11796479)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "75025876-EC22-4E65-8770-91B4382AD85E", 5.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, "1B339D02-213B-44AD-8643-BCDC2A808A68", 1.5, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        DEMONIC_POWER = new NormStatusEffect(StatusEffectCategory.BENEFICIAL, 11796479)
                .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "E6155371-39D1-4025-BD41-2EBAAADE5454", 0.05, EntityAttributeModifier.Operation.ADDITION);
    }

    static class NormStatusEffect extends StatusEffect {
        public NormStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
            super(statusEffectCategory, color);
        }
    }
}


