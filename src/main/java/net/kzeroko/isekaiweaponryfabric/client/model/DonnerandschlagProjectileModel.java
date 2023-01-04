package net.kzeroko.isekaiweaponryfabric.client.model;

import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.entity.CrescentroseProjectile;
import net.kzeroko.isekaiweaponryfabric.entity.DonnerandschlagProjectile;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DonnerandschlagProjectileModel extends AnimatedGeoModel<DonnerandschlagProjectile> {
    @Override
    public Identifier getModelResource(DonnerandschlagProjectile object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "geo/donnerandschlag_projectile.geo.json");
    }

    @Override
    public Identifier getTextureResource(DonnerandschlagProjectile object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "textures/entity/projectiles/donnerandschlag_projectile.png");
    }

    @Override
    public Identifier getAnimationResource(DonnerandschlagProjectile animatable) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "animations/donnerandschlag_projectile.animation.json");
    }

}
