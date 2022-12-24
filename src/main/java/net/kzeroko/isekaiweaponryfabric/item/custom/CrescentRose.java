package net.kzeroko.isekaiweaponryfabric.item.custom;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.kzeroko.isekaiweaponryfabric.config.MidnightConfigConstructor;
import net.kzeroko.isekaiweaponryfabric.entity.CrescentroseProjectile;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiEntities;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;

public class CrescentRose extends SwordItem implements IAnimatable, ISyncable {
    private static final int ANIM_OPEN = 0;
    private static final String controllerName = "transController";
    public AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public CrescentRose(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, MidnightConfigConstructor.crescent_rose_damage, attackSpeed, settings);
        GeckoLibNetwork.registerSyncable(this);;
    }

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        AnimationController<CrescentRose> controller = new AnimationController(this, controllerName, 1, this::predicate);
        data.addAnimationController(controller);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)user;
            ItemStack stack = player.getMainHandStack();
            if (!player.getItemCooldownManager().isCoolingDown(this)) {
                if (!world.isClient)
                {
                    player.getItemCooldownManager().set(this, 20 * 15);
                    CrescentroseProjectile entity = new CrescentroseProjectile(IsekaiEntities.CRESCENTROSE_PROJECTILE, world, user);
                    entity.setAgeAndPoints(30, 75);
                    entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 1.0F);
                    entity.setDamage(MidnightConfigConstructor.crescentrose_bullet_damage);
                    stack.damage(1, user, p -> p.sendToolBreakStatus(user.getActiveHand()));
                    world.spawnEntity(entity);
                    world.playSound(null, user.getBlockPos(), IsekaiSounds.CRESCENTROSE_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 3, 1, false, false, false));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 3, 2, false, false, false));
                }
            }
            if (!world.isClient) {
                final int id = GeckoLibUtil.guaranteeIDForStack(user.getStackInHand(hand), (ServerWorld) world);
                GeckoLibNetwork.syncAnimation(user, this, id, ANIM_OPEN);
                for (PlayerEntity otherPlayer : PlayerLookup.tracking(user)) {
                    GeckoLibNetwork.syncAnimation(otherPlayer, this, id, ANIM_OPEN);
                }
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void onAnimationSync(int id, int state) {
        if (state == ANIM_OPEN) {
            @SuppressWarnings("rawtypes")
            final AnimationController controller = GeckoLibUtil.getControllerForID(this.factory, id, controllerName);
            if (controller.getAnimationState() == AnimationState.Stopped) {
                controller.markNeedsReload();
                controller.setAnimation(new AnimationBuilder().addAnimation("trans", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            }
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.weapon_rwby").formatted(Formatting.RED, Formatting.BOLD));
        tooltip.add(Text.translatable("desc.isekaiweaponryfabric.crescent_rose").formatted(Formatting.GOLD, Formatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.crescent_rose_story").formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.translatable("desc.isekaiweaponryfabric.shift").formatted(Formatting.BOLD));
        }
        super.appendTooltip(itemStack, world, tooltip, tooltipContext);
    }

}