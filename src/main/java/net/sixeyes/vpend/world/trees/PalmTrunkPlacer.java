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

public class PalmTrunkPlacer extends TrunkPlacer {
    // Use the fillTrunkPlacerFields to create our codec
    public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance).apply(instance, PalmTrunkPlacer::new));

    public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrees.PALM_TRUNK_PLACER;
    }

    private int getOffset(int i, int form) {
        switch (form) {
            case 1:
                // parabola 1#
                return MathHelper.ceil(Math.pow(i - (MathHelper.sin(i)/1.5f), 0.5));
            case 2:
                // parabola 2#
                return MathHelper.ceil(Math.pow(i - (MathHelper.sin(i)/1.5f), 0.2));
            default:
                return 0;
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

        // forming the trunk
        int form = random.nextBetween(1,2), side = (random.nextBetween(0,1)) == 0 ? -1 : 1, offset = 0;
        for (int i = 0; i <= height; i++) {
            offset = getOffset(i, form)*side;
            this.getAndSetState(world, placer, random, startPos.up(i).offset(direction.getAxis(), offset), config);
        }

        // use the tip of the chosen curve as the center for the foliage
        offset = getOffset(height, form)*side;
        return ImmutableList.of(new FoliagePlacer.TreeNode(
                startPos.up(height).offset(direction.getAxis(), offset), 0, false));
    }
}
