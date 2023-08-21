package net.sixeyes.vpend.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record NoiseVegetationPatchFeatureConfig(
        TagKey<Block> replaceable,
        BlockStateProvider groundState,
        RegistryEntry<PlacedFeature> vegetationFeature,
        float vegetationChance,
        IntProvider radius) implements FeatureConfig {

    public NoiseVegetationPatchFeatureConfig(
            TagKey<Block> replaceable,
            BlockStateProvider groundState,
            RegistryEntry<PlacedFeature> vegetationFeature,
            float vegetationChance,
            IntProvider radius) {
        this.replaceable = replaceable; // will be used
        this.groundState = groundState; // will be used
        this.vegetationFeature = vegetationFeature; // will be used, a list of choir growth, bubbles, and chorus
        this.vegetationChance = vegetationChance;
        this.radius = radius;
    }

    public static final Codec<NoiseVegetationPatchFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    TagKey.codec(RegistryKeys.BLOCK).fieldOf("replaceable").forGetter(NoiseVegetationPatchFeatureConfig::replaceable),
                    BlockStateProvider.TYPE_CODEC.fieldOf("ground_state").forGetter(NoiseVegetationPatchFeatureConfig::groundState),
                    PlacedFeature.REGISTRY_CODEC.fieldOf("vegetation_feature").forGetter(NoiseVegetationPatchFeatureConfig::vegetationFeature),
                    Codec.floatRange(0.0f, 1.0f).fieldOf("vegetation_chance").forGetter(NoiseVegetationPatchFeatureConfig::vegetationChance),
                    IntProvider.VALUE_CODEC.fieldOf("radius").forGetter(NoiseVegetationPatchFeatureConfig::radius)
            ).apply(instance, NoiseVegetationPatchFeatureConfig::new));

    public TagKey<Block> replaceable() {
        return replaceable;
    }
    public BlockStateProvider groundState() {
        return groundState;
    }
    public RegistryEntry<PlacedFeature> vegetationFeature() {
        return vegetationFeature;
    }
    public float vegetationChance() {
        return vegetationChance;
    }
    public IntProvider radius() {
        return radius;
    }
}
