package net.sixeyes.vpend.world.trees;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BigPalmTrunkPlacer extends TrunkPlacer {
    // Use the fillTrunkPlacerFields to create our codec
    public static final Codec<BigPalmTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance).apply(instance, BigPalmTrunkPlacer::new));

    public BigPalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrees.BIG_PALM_TRUNK_PLACER;
    }

    private int getOffset(int i, int form) {
        switch (form) {
            case 1:
                // parabola 1#
                return MathHelper.ceil(Math.pow(i - (MathHelper.sin(3*i)/1.5f), 0.5));
            case 2:
                // parabola 2#
                return MathHelper.ceil(Math.pow(i - (MathHelper.sin(3*i)/1.5f), 0.75));
            default:
                return 0;
        }
    }

    private void generateCube(TestableWorld world, BiConsumer<BlockPos, BlockState> placer, Random random, BlockPos startPos, int thickness, TreeFeatureConfig config) {
        for (int x = 0; x < thickness; x++) {
            for (int y = 0; y < thickness; y++) {
                for (int z = 0; z < thickness; z++) {
                    BlockPos pos = startPos.north(x).east(z).up(y);
                    this.getAndSetState(world, placer, random, pos, config);
                }
            }
        }
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> placer,
            Random random, int height, BlockPos startPos,
            TreeFeatureConfig config) {

        // Set the ground beneath the trunk to 'dirt'
        setToDirt(world, placer, random, startPos.down(), config);
        ArrayList<FoliagePlacer.TreeNode> list = Lists.newArrayList();
        Direction direction = Direction.Type.HORIZONTAL.random(random);

        // forming the trunk and using generateCube to make thickness
        int form = random.nextBetween(1,2), side = (random.nextBetween(0,1)) == 0 ? -1 : 1, offset = 0;
        for (int i = 0; i <= height; i+=2) {
            offset = getOffset(i, form)*side;
            BlockPos basePos = startPos.up(i).offset(direction.getAxis(), offset);
            generateCube(world, placer, random, basePos, 2, config);
        }

        // use the tip of the chosen curve as the center for the foliage
        offset = getOffset(height+1, form)*side;
        return ImmutableList.of(new FoliagePlacer.TreeNode(
                startPos.up(height+1).offset(direction.getAxis(), offset), 0, true));
    }
}
