package net.sixeyes.vpend.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.function.Predicate;

public class EndVegetationFeature extends Feature<EndVegetationFeatureConfig> {
    public EndVegetationFeature(Codec<EndVegetationFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<EndVegetationFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockState blockState = structureWorldAccess.getBlockState(blockPos.down());
        EndVegetationFeatureConfig endVegetationFeatureConfig = context.getConfig();
        Random random = context.getRandom();

        Predicate<BlockState> predicate = state -> state.isIn(endVegetationFeatureConfig.ground());

        if (predicate.test(blockState)) {
            return false;
        }

        int i = blockPos.getY();
        if (i < structureWorldAccess.getBottomY() + 1 || i + 1 >= structureWorldAccess.getTopY()) {
            return false;
        }

        int j = 0;
        for (int k = 0; k < endVegetationFeatureConfig.spreadWidth() * endVegetationFeatureConfig.spreadWidth(); ++k) {
            BlockPos blockPos2 = blockPos.add(
                    random.nextInt(endVegetationFeatureConfig.spreadWidth()) - random.nextInt(endVegetationFeatureConfig.spreadWidth()),
                    random.nextInt(endVegetationFeatureConfig.spreadHeight()) - random.nextInt(endVegetationFeatureConfig.spreadHeight()),
                    random.nextInt(endVegetationFeatureConfig.spreadWidth()) - random.nextInt(endVegetationFeatureConfig.spreadWidth()));
            BlockState blockState2 = endVegetationFeatureConfig.stateProvider().get(random, blockPos2);
            if (!structureWorldAccess.isAir(blockPos2) || blockPos2.getY() <= structureWorldAccess.getBottomY() || !blockState2.canPlaceAt(structureWorldAccess, blockPos2)) continue;
            structureWorldAccess.setBlockState(blockPos2, blockState2, Block.NOTIFY_LISTENERS);
            ++j;
        }
        return j > 0;
    }
}
