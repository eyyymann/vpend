package net.sixeyes.vpend.block;

import net.minecraft.block.*;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.sixeyes.vpend.registry.ModTags;

public class PhantomPlantBlock extends PlantBlock {
    public PhantomPlantBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(ModTags.PHANTOM_TROPICS_GROUND);
    }
}
