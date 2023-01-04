package net.kzeroko.isekaiweaponryfabric.item.weapon;

import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
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

public class SpuitLance extends SwordItem {
    public SpuitLance(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, MidnightConfigConstructor.spuit_lance_damage, attackSpeed, settings);
    }

    public static float WeaponDamage = MidnightConfigConstructor.spuit_lance_damage;

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld world = (ServerWorld) attacker.world;
        if (attacker instanceof ServerPlayerEntity player) {
            if (!player.getItemCooldownManager().isCoolingDown(this)) {
                player.getItemCooldownManager().set(this, 20 * 5);
                world.playSoundFromEntity(null, target, IsekaiSounds.CAST_REPLENISH, SoundCategory.PLAYERS, 1.0f, 1.0F);
                player.heal(WeaponDamage / MidnightConfigConstructor.spuit_lance_heal_portion);
            }
            if (target.getGroup() == EntityGroup.UNDEAD) {
                target.damage(DamageSource.GENERIC, MidnightConfigConstructor.spuit_lance_damage + MidnightConfigConstructor.spuit_lance_extradamage);
            }
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
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.weapon_overlord").formatted(Formatting.GOLD, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.spuit_lance").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.spuit_lance_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}