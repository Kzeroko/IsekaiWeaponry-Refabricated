package net.kzeroko.isekaiweaponryfabric.client.model;

import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.item.weapon.CrescentRose;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrescentroseModel extends AnimatedGeoModel<CrescentRose> {

    @Override
    public Identifier getModelResource(CrescentRose object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "geo/crescent_rose.geo.json");
    }

    @Override
    public Identifier getTextureResource(CrescentRose object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "textures/item/weapons/crescent_rose.png");
    }

    @Override
    public Identifier getAnimationResource(CrescentRose animatable) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "animations/crescent_rose.animation.json");
    }

}