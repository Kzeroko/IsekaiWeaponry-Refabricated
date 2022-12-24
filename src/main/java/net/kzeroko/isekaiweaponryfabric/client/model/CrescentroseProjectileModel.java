package net.kzeroko.isekaiweaponryfabric.client.model;

import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.entity.CrescentroseProjectile;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrescentroseProjectileModel extends AnimatedGeoModel<CrescentroseProjectile> {
    @Override
    public Identifier getModelResource(CrescentroseProjectile object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "geo/crescentrose_projectile.geo.json");
    }

    @Override
    public Identifier getTextureResource(CrescentroseProjectile object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "textures/entity/projectiles/crescentrose_projectile.png");
    }

    @Override
    public Identifier getAnimationResource(CrescentroseProjectile animatable) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "animations/crescentrose_projectile.animation.json");
    }

}
