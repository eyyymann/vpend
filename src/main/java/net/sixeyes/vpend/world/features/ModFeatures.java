package net.sixeyes.vpend.world.features;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.sixeyes.vpend.VPEndMod;

public class ModFeatures {

    public static final Identifier END_VEGETATION_FEATURE_ID = new Identifier("vpend", "end_vegetation");
    public static Feature<EndVegetationFeatureConfig> END_VEGETATION_FEATURE = new EndVegetationFeature(
            EndVegetationFeatureConfig.CODEC);
    public static final Identifier END_CRATER_FEATURE_ID = new Identifier("vpend", "end_crater");
    public static Feature<DefaultFeatureConfig> END_CRATER_FEATURE = new EndCraterFeature(DefaultFeatureConfig.CODEC);

    public static final Identifier NOISE_VEGETATION_PATCH_FEATURE_ID = new Identifier("vpend", "noise_vegetation_patch");
    public static Feature<NoiseVegetationPatchFeatureConfig> NOISE_VEGETATION_PATCH_FEATURE = new NoiseVegetationPatchFeature(NoiseVegetationPatchFeatureConfig.CODEC);

    public static void registerModFeatures() {

        Registry.register(Registries.FEATURE, END_VEGETATION_FEATURE_ID, END_VEGETATION_FEATURE);
        Registry.register(Registries.FEATURE, END_CRATER_FEATURE_ID, END_CRATER_FEATURE);
        Registry.register(Registries.FEATURE, NOISE_VEGETATION_PATCH_FEATURE_ID, NOISE_VEGETATION_PATCH_FEATURE);
        VPEndMod.LOGGER.info("Registering Mod Features for " + VPEndMod.MOD_ID);
    }
}
