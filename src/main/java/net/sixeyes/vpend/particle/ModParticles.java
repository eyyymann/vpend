package net.sixeyes.vpend.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.VPEndMod;

public class ModParticles {

    // STATICS
    public static final DefaultParticleType PHANTOM_REMNANT = FabricParticleTypes.simple();

    // METHODS
    private static void register(String name, DefaultParticleType particle) {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(VPEndMod.MOD_ID, name), particle);
    }

    public static void registerModParticles() {

        register("phantom_remnant", PHANTOM_REMNANT);
        VPEndMod.LOGGER.info("Registering Mod Particles " + VPEndMod.MOD_ID);
    }
}
