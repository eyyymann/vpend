package net.sixeyes.vpend.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class TallPhantomPlantBlock extends TallPlantBlock {

    public TallPhantomPlantBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.PHANTOM_SKIN) || floor.isOf(ModBlocks.PHANTOM_END_STONE);
    }
}
