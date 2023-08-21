package net.sixeyes.vpend.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class NoiseVegetationPatchFeature extends Feature<NoiseVegetationPatchFeatureConfig> {
    public NoiseVegetationPatchFeature(Codec<NoiseVegetationPatchFeatureConfig> configCodec) {
        super(configCodec);
    }

    public Set<BlockPos> placeGround() {
        return new HashSet<BlockPos>();
    }

    @Override
    public boolean generate(FeatureContext<NoiseVegetationPatchFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        NoiseVegetationPatchFeatureConfig noiseVegetationPatchFeatureConfig = context.getConfig();
        Random random = context.getRandom();
        BlockPos blockPos = context.getOrigin();
        Predicate<BlockState> predicate = state -> state.isIn(noiseVegetationPatchFeatureConfig.replaceable());

        // placing down ground section
        Set<BlockPos> positions = placeGround();

        // generatin vegetation section
        this.generateVegetation(context, structureWorldAccess, noiseVegetationPatchFeatureConfig, random, positions);

        return true;
    }

    protected void generateVegetation(
            FeatureContext<NoiseVegetationPatchFeatureConfig> context,
            StructureWorldAccess world,
            NoiseVegetationPatchFeatureConfig config,
            Random random,
            Set<BlockPos> positions) {

        for (BlockPos blockPos : positions) {
            if (!(config.vegetationChance() > 0.0f) || !(random.nextFloat() < config.vegetationChance())) continue;
            this.generateVegetationFeature(world, config, context.getGenerator(), random, blockPos);
        }
    }

    protected boolean generateVegetationFeature(StructureWorldAccess world, NoiseVegetationPatchFeatureConfig config, ChunkGenerator generator, Random random, BlockPos pos) {
        return config.vegetationFeature().value().generateUnregistered(world, generator, random, pos);
    }
}
