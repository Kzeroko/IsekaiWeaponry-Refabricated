package net.kzeroko.isekaiweaponryfabric.item.armor;

import net.kzeroko.isekaiweaponryfabric.init.IsekaiArmors;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiEffects;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KisarasDemonset extends ArmorItem implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public KisarasDemonset(ArmorMaterial materialIn, EquipmentSlot slot, Settings builder) {
        super(materialIn, slot, builder);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (entity instanceof PlayerEntity player) {
            if (this.isChestEquipped(player) && this.isHeadEquipped(player)) {
                player.addStatusEffect(new StatusEffectInstance(IsekaiEffects.DEMONIC_POWER, 20, 0, false, false, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 220, 0, false, false, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20, 1, false, false, false));
            }
        }
    }

    private boolean isHeadEquipped(PlayerEntity player) {
        ItemStack head = player.getInventory().getArmorStack(3);
        return !head.isEmpty() && head.getItem() == IsekaiArmors.KISARASDEMONSET_HEAD;
    }

    private boolean isChestEquipped(PlayerEntity player) {
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        return !chestplate.isEmpty() && chestplate.getItem() == IsekaiArmors.KISARASDEMONSET_CHEST;
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kisarasdemonset.animate", EDefaultLoopTypes.LOOP));
        if (livingEntity instanceof ArmorStandEntity) {
            return PlayState.CONTINUE;
        }
        List<Item> armorList = new ArrayList<>(4);
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                if (livingEntity.getEquippedStack(slot) != null) {
                    armorList.add(livingEntity.getEquippedStack(slot).getItem());
                }
            }
        }

        boolean isWearingAll = armorList.containsAll(Arrays.asList(IsekaiArmors.KISARASDEMONSET_HEAD, IsekaiArmors.KISARASDEMONSET_CHEST));
        return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "armorcontroller2", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.armor_engagekiss").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.kisarasdemonset").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.kisarasdemonset_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}
