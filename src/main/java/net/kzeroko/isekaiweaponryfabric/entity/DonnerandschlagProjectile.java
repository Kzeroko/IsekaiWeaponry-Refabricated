package net.kzeroko.isekaiweaponryfabric.entity;

import net.kzeroko.isekaiweaponryfabric.init.IsekaiSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class DonnerandschlagProjectile extends PersistentProjectileEntity implements IAnimatable, IAnimationTickable {
    private static final TrackedData<Integer> POINTS;
    private static final TrackedData<Integer> MAX_AGE;
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public DonnerandschlagProjectile(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public DonnerandschlagProjectile(EntityType<? extends PersistentProjectileEntity> type, World world, LivingEntity owner) {
        super(type, owner, world);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(POINTS, 75);
        this.dataTracker.startTracking(MAX_AGE, 30);
    }

    public void setAgeAndPoints(int maxAge, int particlePoints) {
        this.dataTracker.set(MAX_AGE, maxAge);
        this.dataTracker.set(POINTS, particlePoints);
    }

    public double getMaxAge() {
        return (double)(Integer)this.dataTracker.get(MAX_AGE);
    }

    public void tick() {
        super.tick();
        Vec3d vec3d = this.getVelocity();
        double e = vec3d.x;
        double f = vec3d.y;
        double g = vec3d.z;

        for(int i = 0; i < 4; ++i) {
            this.world.addParticle(this.getParticleType(), this.getX() + e * (double)i / 4.0D, this.getY() + f * (double)i / 4.0D, this.getZ() + g * (double)i / 4.0D, -e, -f + 0.2D, -g);
        }

        if ((double)this.age > this.getMaxAge()) {
            this.discard();
        }

    }

    public boolean isAttackable() {
        return false;
    }

    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.discard();
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        this.discard();
    }

    public void onRemoved() {
        super.onRemoved();
    }

    protected SoundEvent getHitSound() {
        return IsekaiSounds.DONNERANDSCHLAG_HIT;
    }

    protected ParticleEffect getParticleType() {
        return ParticleTypes.CRIMSON_SPORE;
    }

    protected float getDragInWater() {
        return 1.0F;
    }

    protected ItemStack asItemStack() {
        return null;
    }

    public boolean hasNoGravity() {
        return true;
    }

    public int tickTimer() {
        return this.age;
    }

    public void registerControllers(AnimationData data) {
    }

    public AnimationFactory getFactory() {
        return this.factory;
    }

    static {
        POINTS = DataTracker.registerData(DonnerandschlagProjectile.class, TrackedDataHandlerRegistry.INTEGER);
        MAX_AGE = DataTracker.registerData(DonnerandschlagProjectile.class, TrackedDataHandlerRegistry.INTEGER);
    }
}