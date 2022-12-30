package net.kzeroko.isekaiweaponryfabric.item.custom;

import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class RazorEdge extends SwordItem {
    public RazorEdge(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, MidnightConfigConstructor.razor_edge_damage, attackSpeed, settings);
    }

    public static float WeaponDamage = MidnightConfigConstructor.razor_edge_damage;

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.damage(DamageSource.MAGIC, WeaponDamage);
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
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.razor_edge").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.razor_edge_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}