package net.sixeyes.vpend.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.sixeyes.vpend.block.ModBlocks;
import net.sixeyes.vpend.registry.ModTags;
import org.joml.Math;

public class EndCraterFeature extends Feature<DefaultFeatureConfig> {

    public EndCraterFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public int chance(Random random, int radius, int x, int z) {
        boolean xChance = random.nextBetween(0,radius) > MathHelper.abs(x)+2;
        boolean zChance = random.nextBetween(0,radius) > MathHelper.abs(z)+2;
        return xChance && zChance ? 1 : 0;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        Random random = context.getRandom();
        BlockPos blockPos = context.getOrigin();

        int radius = random.nextInt(28) + 5;
        int min_depth = random.nextInt(3) + 2;
        float Afactor = 1/(float)(radius + random.nextInt(2));
        float Bfactor = 1/(float)(radius + random.nextInt(2));

        // add cracks (curved lines) coming out of center thing
        int x, y, z, depth = 0;
        for (x = -radius; x <= radius; x++) {
            for (z = -radius; z <= radius; z++) {
                //int depth_adder = random.nextInt(2) * chance(random, radius, x, z);
                int depth_adder = 0;
                for (y = min_depth + depth_adder; y >= 0; y--) {
                    // makes a depth variable
                    depth = (int)(Afactor * MathHelper.square(x + 2*MathHelper.sin(x)/radius)
                            + Bfactor * MathHelper.square(z - 2*MathHelper.cos(z)/radius));
                    depth = min_depth + depth_adder - depth - y;

                    this.setBlockState(structureWorldAccess, blockPos.north(x).down(depth).east(z), Blocks.AIR.getDefaultState());
                }

                // replaces the very bottom with cracked end stone sometimes
                if (random.nextBetween(1,100) > 90 &&
                        (blockPos.north(x).down(depth+1).east(z).getY()) < blockPos.getY() &&
                        structureWorldAccess.getBlockState(blockPos.north(x).down(depth+1).east(z)).isIn(ModTags.END_CRATER_REPLACEABLE))
                    this.setBlockState(structureWorldAccess, blockPos.north(x).down(depth+1).east(z), ModBlocks.CRACKED_END_STONE.getDefaultState());
            }
        }

        return true;
    }
}
