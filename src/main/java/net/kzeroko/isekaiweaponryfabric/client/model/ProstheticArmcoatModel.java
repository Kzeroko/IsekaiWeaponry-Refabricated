package net.kzeroko.isekaiweaponryfabric.client.model;

import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.item.armor.ProstheticArmcoat;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ProstheticArmcoatModel extends AnimatedGeoModel<ProstheticArmcoat> {
    @Override
    public Identifier getModelResource(ProstheticArmcoat object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "geo/prosthetic_armcoat.geo.json");
    }

    @Override
    public Identifier getTextureResource(ProstheticArmcoat object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "textures/item/armors/prosthetic_armcoat.png");
    }

    @Override
    public Identifier getAnimationResource(ProstheticArmcoat animatable) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "animations/prosthetic_armcoat.animation.json");
    }
}
