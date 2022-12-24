package net.kzeroko.isekaiweaponryfabric.client.renderer;

import net.kzeroko.isekaiweaponryfabric.client.model.CrescentroseModel;
import net.kzeroko.isekaiweaponryfabric.item.custom.CrescentRose;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class CrescentroseRenderer extends GeoItemRenderer<CrescentRose> {
    public CrescentroseRenderer() {
        super(new CrescentroseModel());
    }
}