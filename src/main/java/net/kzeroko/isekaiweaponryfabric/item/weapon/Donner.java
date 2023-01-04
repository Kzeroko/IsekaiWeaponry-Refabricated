package net.kzeroko.isekaiweaponryfabric.item.weapon;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryClient;
import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
import net.kzeroko.isekaiweaponryfabric.entity.DonnerandschlagProjectile;
import net.kzeroko.isekaiweaponryfabric.enums.IsekaiWeaponMaterials;
import net.kzeroko.isekaiweaponryfabric.init.*;
import net.kzeroko.isekaiweaponryfabric.item.RangeWeapon;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;

public class Donner extends RangeWeapon {

    public Donner(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return IsekaiWeaponMaterials.ARIFURETA_GUN.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            ItemStack stack = player.getMainHandStack();
            ItemStack stacko = player.getOffHandStack();
            ItemStack stack1 = new ItemStack(IsekaiRangeWeapons.DONNER);
            ItemStack stack2 = new ItemStack(IsekaiRangeWeapons.SCHLAG);
            if (stack.getDamage() < (stack.getMaxDamage() - 1) && !player.getEquippedStack(EquipmentSlot.OFFHAND).isItemEqual(stack2)) {
                player.getItemCooldownManager().set(this, 15);
                if (!world.isClient) {
                    DonnerandschlagProjectile entity = new DonnerandschlagProjectile(IsekaiEntities.DONNERANDSCHLAG_PROJECTILE, world, player);
                    entity.setAgeAndPoints(30, 75);
                    entity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 5.0F, 1.0F);
                    entity.setDamage(MidnightConfigConstructor.donnerandschlag_bullet_damage / 5.0F);
                    world.spawnEntity(entity);
                    stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
                    world.playSound(null, player.getBlockPos(), IsekaiSounds.DONNERANDSCHLAG_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    final int id = GeckoLibUtil.guaranteeIDForStack(stack, (ServerWorld) world);
                    GeckoLibNetwork.syncAnimation(player, this, id, ANIM_OPEN);
                    for (PlayerEntity otherPlayer : PlayerLookup.tracking(player)) {
                        GeckoLibNetwork.syncAnimation(otherPlayer, this, id, ANIM_OPEN);
                    }
                }
            } if (player.getEquippedStack(EquipmentSlot.MAINHAND).isItemEqual(stack1) && player.getEquippedStack(EquipmentSlot.OFFHAND).isItemEqual(stack2) && stacko.getDamage() < (stacko.getMaxDamage() - 1) && stack.getDamage() < (stack.getMaxDamage() - 1)) {
                player.getItemCooldownManager().set(this, 10);
                player.getItemCooldownManager().set(stack2.getItem(), 10);
                if (!world.isClient) {
                    DonnerandschlagProjectile entity = new DonnerandschlagProjectile(IsekaiEntities.DONNERANDSCHLAG_PROJECTILE, world, player);
                    entity.setAgeAndPoints(30, 75);
                    entity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 5.0F, 1.0F);
                    entity.setDamage(MidnightConfigConstructor.donnerandschlag_bullet_damage / 2.5F);
                    world.spawnEntity(entity);
                    stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
                    stacko.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
                    world.playSound(null, player.getBlockPos(), IsekaiSounds.DONNERANDSCHLAG_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
        return super.use(world, user, hand);
    }

    public void reload(PlayerEntity user, Hand hand) {
        if (user.getStackInHand(hand).getItem() instanceof Donner) {
            while (!user.isCreative() && user.getStackInHand(hand).getDamage() != 0
                    && user.getInventory().count(IsekaiMiscItems.ALLOYED_BULLETS) > 0
                    && user.getStackInHand(hand).getDamage() == 6)
            {
                user.getItemCooldownManager().set(this, 20);
                removeAmmo(IsekaiMiscItems.ALLOYED_BULLETS, user);
                user.getStackInHand(hand).damage(-6, user, s -> user.sendToolBreakStatus(hand));
                user.getEntityWorld().playSound(null, user.getX(), user.getY(), user.getZ(),
                        IsekaiSounds.DONNERANDSCHLAG_RELOAD, SoundCategory.PLAYERS, 1.00F, 1.0F);
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient) {
            if (((PlayerEntity) entity).getMainHandStack().getItem() instanceof Donner
                    && IsekaiweaponryClient.reload.isPressed() && selected) {
                PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                passedData.writeBoolean(true);
                ClientPlayNetworking.send(IsekaiweaponryFabric.DONNER, passedData);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.weapon_arifureta").formatted(Formatting.RED, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.donner_and_schlag").formatted(Formatting.GOLD, Formatting.BOLD));

        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.rangedamage", (MidnightConfigConstructor.donnerandschlag_bullet_damage))
                .formatted(Formatting.BOLD).formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.leftammo", (itemStack.getMaxDamage() - itemStack.getDamage() - 1))
                .formatted(Formatting.BOLD).formatted(Formatting.GOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.donner_and_schlag_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }
}
