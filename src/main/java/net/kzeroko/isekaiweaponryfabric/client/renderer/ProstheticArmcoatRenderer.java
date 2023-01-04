package net.kzeroko.isekaiweaponryfabric.client.renderer;

import net.kzeroko.isekaiweaponryfabric.client.model.ProstheticArmcoatModel;
import net.kzeroko.isekaiweaponryfabric.item.armor.ProstheticArmcoat;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ProstheticArmcoatRenderer extends GeoArmorRenderer<ProstheticArmcoat> {
    public ProstheticArmcoatRenderer() {
        super(new ProstheticArmcoatModel());
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}