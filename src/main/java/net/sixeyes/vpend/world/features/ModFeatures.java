package net.sixeyes.vpend.world.features;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.sixeyes.vpend.VPEndMod;

public class ModFeatures {

    public static final Identifier END_VEGETATION_FEATURE_ID = new Identifier("vpend", "end_vegetation");
    public static Feature<EndVegetationFeatureConfig> END_VEGETATION_FEATURE = new EndVegetationFeature(
            EndVegetationFeatureConfig.CODEC);

    public static void registerModFeatures() {

        Registry.register(Registries.FEATURE, END_VEGETATION_FEATURE_ID, END_VEGETATION_FEATURE);
        VPEndMod.LOGGER.info("Registering Mod Features for " + VPEndMod.MOD_ID);
    }
}
