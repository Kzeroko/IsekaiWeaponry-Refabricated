package net.kzeroko.isekaiweaponryfabric.item.custom;

import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiEffects;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class OrigamiKatenRougetsuAmahisa extends SwordItem {
    public OrigamiKatenRougetsuAmahisa(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, MidnightConfigConstructor.origami_katenrougetsuamahisa_damage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)user;
            if (!player.getItemCooldownManager().isCoolingDown(this)) {
                if (!world.isClient)
                {
                    player.getItemCooldownManager().set(this, 20 * 90);
                    world.playSound(null, user.getBlockPos(), IsekaiSounds.CAST_BUFF, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    player.addStatusEffect(new StatusEffectInstance(IsekaiEffects.TENJU, 20 * 40, 0, false, false, true));
                }
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.weapon_origami2").formatted(Formatting.AQUA, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.origami_katenrougetsuamahisa").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.origami_katenrougetsuamahisa_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}