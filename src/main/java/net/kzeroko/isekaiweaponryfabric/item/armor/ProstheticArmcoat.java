package net.kzeroko.isekaiweaponryfabric.item.armor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.kzeroko.isekaiweaponryfabric.init.IsekaiArmors;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
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

public class ProstheticArmcoat extends ArmorItem implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public ProstheticArmcoat(ArmorMaterial materialIn, EquipmentSlot slot, Item.Settings builder) {
        super(materialIn, slot, builder);
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.prosthetic_armcoat.animate", EDefaultLoopTypes.LOOP));
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

        boolean isWearingAll = armorList.containsAll(Arrays.asList(IsekaiArmors.PROSTHETIC_ARMCOAT));
        return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "armorcontroller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.armor_arifureta").formatted(Formatting.RED, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.prosthetic_armcoat").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.prosthetic_armcoat_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}
