package net.sixeyes.vpend.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record EndVegetationFeatureConfig(BlockStateProvider stateProvider, int spreadWidth, int spreadHeight, TagKey<Block> ground) implements FeatureConfig {

    public EndVegetationFeatureConfig(BlockStateProvider stateProvider, int spreadWidth, int spreadHeight, TagKey<Block> ground) {
        this.stateProvider = stateProvider;
        this.spreadWidth = spreadWidth;
        this.spreadHeight = spreadHeight;
        this.ground = ground;
    }

    public static Codec<EndVegetationFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance ->
                    instance.group(
                            BlockStateProvider.TYPE_CODEC.fieldOf("state_provider").forGetter(EndVegetationFeatureConfig::stateProvider),
                            Codecs.POSITIVE_INT.fieldOf("spread_width").forGetter(EndVegetationFeatureConfig::spreadWidth),
                            Codecs.POSITIVE_INT.fieldOf("spread_height").forGetter(EndVegetationFeatureConfig::spreadHeight),
                            (TagKey.codec(RegistryKeys.BLOCK).fieldOf("ground")).forGetter(EndVegetationFeatureConfig::ground)
                    ).apply(instance, EndVegetationFeatureConfig::new)
    );

    public BlockStateProvider stateProvider() {
        return stateProvider;
    }
    public int spreadWidth() {
        return spreadWidth;
    }
    public int spreadHeight() {
        return spreadHeight;
    }
    public TagKey<Block> ground() {return ground;}
}
