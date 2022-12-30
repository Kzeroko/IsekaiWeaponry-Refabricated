package net.kzeroko.isekaiweaponryfabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kzeroko.isekaiweaponryfabric.client.renderer.CrescentroseProjectileRenderer;
import net.kzeroko.isekaiweaponryfabric.client.renderer.CrescentroseRenderer;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiEntities;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiWeapons;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IsekaiweaponryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GeoItemRenderer.registerItemRenderer(IsekaiWeapons.CRESCENT_ROSE, new CrescentroseRenderer());
        EntityRendererRegistry.register(IsekaiEntities.CRESCENTROSE_PROJECTILE, CrescentroseProjectileRenderer::new);
    }
}