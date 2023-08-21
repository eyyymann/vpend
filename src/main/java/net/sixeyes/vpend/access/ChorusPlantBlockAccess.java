package net.sixeyes.vpend.access;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public interface ChorusPlantBlockAccess {

    public boolean hasRandomTicks(BlockState state);

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random);
}
