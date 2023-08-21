package net.sixeyes.vpend.world.trees;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance).and(IntProvider.createValidatingCodec(1, 512).fieldOf("foliage_height").forGetter(PalmFoliagePlacer::getFoliageHeight)).apply(instance, PalmFoliagePlacer::new));

    private final IntProvider foliageHeight;

    public PalmFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider foliageHeight) {
        super(radius, offset);

        this.foliageHeight = foliageHeight;
    }

    public IntProvider getFoliageHeight() {
        return this.foliageHeight;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModTrees.PALM_FOLIAGE_PLACER;
    }

    protected static boolean placeFoliageBlock(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos pos) {
        if (!TreeFeature.canReplace(world, pos)) {
            return false;
        }
        BlockState blockState = config.foliageProvider.get(random, pos);
        if (blockState.contains(Properties.WATERLOGGED)) {
            blockState = (BlockState)blockState.with(Properties.WATERLOGGED, world.testFluidState(pos, fluidState -> fluidState.isEqualAndStill(Fluids.WATER)))
                    .with(Properties.PERSISTENT, Boolean.TRUE);
        }
        placer.placeBlock(pos, blockState);
        return true;
    }

    private void generateCube(TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, BlockPos startPos, int thickness, TreeFeatureConfig config) {
        for (int x = 0; x < thickness; x++) {
            for (int y = 0; y < thickness; y++) {
                for (int z = 0; z < thickness; z++) {
                    BlockPos pos = startPos.north(x).east(z).up(y);
                    placeFoliageBlock(world, placer, random, config, pos);
                }
            }
        }
    }

    private int XOR1(int a, int b) {
        return (a*a == b*b ? 0 : 1);
    }

    private int XOR2(int a, int b) {
        return ((a == b || a==-b) ? 1 : 0);
    }

    protected void generateParabola(TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos blockPos,
                                    int radius, int thickness, int xChange, int zChange, float Factor) {
        float x = 0, y = 0, z = 0, multiplier = 2;
        BlockPos pos = blockPos;
        for (int i = -radius + thickness*XOR2(xChange, zChange); i < radius + 1 - thickness*XOR2(xChange, zChange); i+=thickness) {
            x = i*xChange;
            z = i*zChange;
            y = multiplier * (-1f/(float)Math.pow(2,radius + XOR1(xChange, zChange) )*(MathHelper.square(
                    (Factor * x * xChange) + (Factor * z * zChange * XOR1(xChange, zChange) ) )));
            pos = blockPos.up((int)y).north((int)x).east((int)z);
            generateCube(world, placer, random, pos, thickness, config);
        }
    }

    protected void generateParabolas(TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos blockPos, boolean bl, int radius) {
        float x_or_z_axis_multiplier = 1f, diagonal_axis_multiplier = 1f;
        int thickness = 1;

        if (bl) { // if the trunk is BigPalmTrunkPlacer
            radius = 2*radius;
            thickness = 2;
            x_or_z_axis_multiplier = 3.5f;
            diagonal_axis_multiplier = 3f;
        } else { // if the trunk is PalmTrunkPlacer
            radius += random.nextBetween(0, 1);
        }

        // top foliage blocks
        generateCube(world, placer, random, blockPos.up(1), thickness, config);

        // first parabola
        generateParabola(world, placer, random, config, blockPos, radius, thickness, 1, 0, x_or_z_axis_multiplier);

        // second perpendicular parabola
        generateParabola(world, placer, random, config, blockPos, radius, thickness, 0, 1, x_or_z_axis_multiplier);

        // first diagonal parabola
        generateParabola(world, placer, random, config, blockPos, radius, thickness, 1, 1, diagonal_axis_multiplier);

        // mirrored diagonal parabola
        generateParabola(world, placer, random, config, blockPos, radius, thickness, 1, -1, diagonal_axis_multiplier);
    }

    @Override
    protected void generate(TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {

        boolean bl = treeNode.isGiantTrunk();
        BlockPos blockPos = treeNode.getCenter().up(offset);

        // make 4 YZ / YX downwards full parabolas, each corresponding to an XZ Axis and halfpoint between them
        this.generateParabolas(world, placer, random, config, blockPos, bl, radius);
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        // Just pick the random height using the IntProvider
        return foliageHeight.get(random);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == 0) {
            return (dx > 1 || dz > 1) && dx != 0 && dz != 0;
        }
        return dx == radius && dz == radius && radius > 0;
    }
}
