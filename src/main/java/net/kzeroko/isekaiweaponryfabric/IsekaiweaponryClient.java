package net.kzeroko.isekaiweaponryfabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kzeroko.isekaiweaponryfabric.client.renderer.CrescentroseProjectileRenderer;
import net.kzeroko.isekaiweaponryfabric.client.renderer.CrescentroseRenderer;
import net.kzeroko.isekaiweaponryfabric.client.renderer.DonnerandschlagProjectileRenderer;
import net.kzeroko.isekaiweaponryfabric.client.renderer.ProstheticArmcoatRenderer;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiArmors;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiEntities;
import net.kzeroko.isekaiweaponryfabric.init.IsekaiWeapons;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import software.bernie.example.client.renderer.armor.GeckoArmorRenderer;
import software.bernie.example.registry.ItemRegistry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class IsekaiweaponryClient implements ClientModInitializer {

    public static KeyBinding reload = new KeyBinding("key.isekaiweaponry.reload", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R,
            "category.isekaiweaponry.binds");


    @Override
    public void onInitializeClient() {
        GeoItemRenderer.registerItemRenderer(IsekaiWeapons.CRESCENT_ROSE, new CrescentroseRenderer());
        EntityRendererRegistry.register(IsekaiEntities.CRESCENTROSE_PROJECTILE, CrescentroseProjectileRenderer::new);
        EntityRendererRegistry.register(IsekaiEntities.DONNERANDSCHLAG_PROJECTILE, DonnerandschlagProjectileRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(new ProstheticArmcoatRenderer(), IsekaiArmors.PROSTHETIC_ARMCOAT);
    }
}