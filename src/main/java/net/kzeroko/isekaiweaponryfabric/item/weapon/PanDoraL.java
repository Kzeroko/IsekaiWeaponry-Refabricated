package net.kzeroko.isekaiweaponryfabric.item.weapon;

import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiEffects;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiSounds;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiWeapons;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class PanDoraL extends SwordItem {
    public PanDoraL(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, MidnightConfigConstructor.pan_doral_damage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)user;
            ItemStack stack = new ItemStack(IsekaiWeapons.PAN_DORAR);
            if (player.getEquippedStack(EquipmentSlot.OFFHAND).isItemEqual(stack)) {
                if (!player.getItemCooldownManager().isCoolingDown(this) && !player.getItemCooldownManager().isCoolingDown(IsekaiWeapons.PAN_DORAR)) {
                    if (!world.isClient)
                    {
                        player.getItemCooldownManager().set(this, 20 * 30);
                        world.playSound(null, user.getBlockPos(), IsekaiSounds.CAST_NIGHTMARE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        player.addStatusEffect(new StatusEffectInstance(IsekaiEffects.PANDORAS_DANCE, 20 * 5, 0, false, false, true));
                        player.addStatusEffect(new StatusEffectInstance(IsekaiEffects.PANDORAS_VISION, 20 * 10, 0, false, false, true));
                    }
                }
            }
        }
        return super.use(world, user, hand);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld world = (ServerWorld) attacker.world;
        if (attacker instanceof ServerPlayerEntity player) {
            if (player.hasStatusEffect(IsekaiEffects.PANDORAS_VISION) && player.hasStatusEffect(IsekaiEffects.PANDORAS_DANCE)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 2, 5));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 2, 3, false, false, false));
            }else if(player.hasStatusEffect(IsekaiEffects.PANDORAS_VISION)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2, 5));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 2, 2, false, false, false));
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
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.weapon_asterisk").formatted(Formatting.AQUA, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.pan_doral").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.pan_doral_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}