package net.kzeroko.isekaiweaponryfabric.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class RangeWeapon extends Item implements IAnimatable, ISyncable {

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public String controllerName = "guncontroller";
    public static final int ANIM_OPEN = 0;
    public static final int ANIM_RELOAD = 1;

    public <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, controllerName, 1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void onAnimationSync(int id, int state) {
        if (state == ANIM_OPEN) {
            final AnimationController<?> controller = GeckoLibUtil.getControllerForID(this.factory, id, controllerName);
            if (controller.getAnimationState() == AnimationState.Stopped) {
                controller.markNeedsReload();
                controller.setAnimation(new AnimationBuilder().addAnimation("fire", EDefaultLoopTypes.PLAY_ONCE));
            }
        }
        if (state == ANIM_RELOAD) {
            final AnimationController<?> controller = GeckoLibUtil.getControllerForID(this.factory, id, controllerName);
            if (controller.getAnimationState() == AnimationState.Stopped) {
                controller.markNeedsReload();
                controller.setAnimation(new AnimationBuilder().addAnimation("reload", EDefaultLoopTypes.PLAY_ONCE));
            }
        }
    }

    public RangeWeapon(Settings settings) {
        super(settings);
        GeckoLibNetwork.registerSyncable(this);
    }

    public void removeAmmo(Item ammo, PlayerEntity playerEntity) {
        if (!playerEntity.isCreative()) {
            for (ItemStack item : playerEntity.getInventory().offHand) {
                if (item.getItem() == ammo) {
                    item.decrement(1);
                    break;
                }
                for (ItemStack item1 : playerEntity.getInventory().main) {
                    if (item1.getItem() == ammo) {
                        item1.decrement(1);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 60000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }
}
