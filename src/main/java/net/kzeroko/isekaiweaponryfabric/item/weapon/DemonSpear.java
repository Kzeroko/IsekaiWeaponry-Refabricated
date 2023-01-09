package net.kzeroko.isekaiweaponryfabric.item.weapon;

import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class DemonSpear extends SwordItem {
    public DemonSpear(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, IsekaiweaponryFabric.config().demonspearDamage, attackSpeed, settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld world = (ServerWorld) attacker.world;
        if (attacker instanceof ServerPlayerEntity && target.getGroup() == EntityGroup.UNDEAD) {
            target.damage(DamageSource.MAGIC, (float) IsekaiweaponryFabric.config().demonspearDamage + IsekaiweaponryFabric.config().demonspearExtraDamage);
            world.playSoundFromEntity(null, target, IsekaiSounds.CAST_ACTIVATE, SoundCategory.PLAYERS, 0.7F, 1.0F);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.weapon_engagekiss").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.demonspear").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.demonspear_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}