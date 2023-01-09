package net.kzeroko.isekaiweaponryfabric.client.model;

import net.kzeroko.isekaiweaponryfabric.IsekaiweaponryFabric;
import net.kzeroko.isekaiweaponryfabric.item.armor.KisarasDemonset;
import net.kzeroko.isekaiweaponryfabric.item.armor.ProstheticArmcoat;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KisarasDemonsetModel extends AnimatedGeoModel<KisarasDemonset> {
    @Override
    public Identifier getModelResource(KisarasDemonset object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "geo/kisarasdemonset.geo.json");
    }

    @Override
    public Identifier getTextureResource(KisarasDemonset object) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "textures/item/armors/kisarasdemonset.png");
    }

    @Override
    public Identifier getAnimationResource(KisarasDemonset animatable) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, "animations/kisarasdemonset.animation.json");
    }
}
