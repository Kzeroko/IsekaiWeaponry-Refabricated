package net.kzeroko.isekaiweaponryfabric.item.weapon;

import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class CharonsGuidance extends SwordItem {
    public CharonsGuidance(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, MidnightConfigConstructor.charons_guidance_damage, attackSpeed, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.weapon_overlord").formatted(Formatting.GOLD, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.charons_guidance").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.charons_guidance_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}