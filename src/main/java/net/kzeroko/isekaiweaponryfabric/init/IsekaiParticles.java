package net.kzeroko.isekaiweaponryfabric.init;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.kzeroko.isekaiweaponryfabric.IsekaiUtils;
import net.minecraft.particle.DefaultParticleType;

public class IsekaiParticles {
    public static final DefaultParticleType TENJU = FabricParticleTypes.simple(true);
    //public static final DefaultParticleType TENJU2 = FabricParticleTypes.simple();

    public IsekaiParticles() {
    }

    public static void init() {
        IsekaiUtils.registerParticle(TENJU, "tenju");
        //IsekaiUtils.registerParticle(TENJU2, "tenju2");
    }
}
