package net.kzeroko.isekaiweaponryfabric;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IsekaiUtils {

    // Tool (unused)
    public static Identifier ID(String id) {
        return new Identifier(IsekaiweaponryFabric.MOD_ID, id);
    }

    // Register
    public static <I extends Item> I registerItem(I item, String name) {
        return (I) Registry.register(Registry.ITEM, new Identifier("isekaiweaponryfabric", name), item);
    }

    public static SoundEvent registerSound(Identifier id, SoundEvent event) {
        return (SoundEvent)Registry.register(Registry.SOUND_EVENT, id, event);
    }

    public static <I extends StatusEffect> I registerEffect(I effect, String name) {
        return (I) Registry.register(Registry.STATUS_EFFECT, new Identifier("isekaiweaponryfabric", name), effect);
    }

    public static <I extends DefaultParticleType> I registerParticle(I particle, String name) {
        return (I) Registry.register(Registry.PARTICLE_TYPE, new Identifier("isekaiweaponryfabric", name), particle);
    }
}
