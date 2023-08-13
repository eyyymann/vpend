package net.sixeyes.vpend.block;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class PhantomPlantBlock extends PlantBlock {
    public PhantomPlantBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.PHANTOM_SKIN) || floor.isOf(ModBlocks.PHANTOM_END_STONE);
    }
}
