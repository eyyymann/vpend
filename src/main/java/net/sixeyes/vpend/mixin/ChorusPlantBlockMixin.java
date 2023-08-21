package net.sixeyes.vpend.mixin;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.sixeyes.vpend.access.ChorusPlantBlockAccess;
import net.sixeyes.vpend.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChorusPlantBlock.class)
public class ChorusPlantBlockMixin implements ChorusPlantBlockAccess {

    @Inject(method = "canPlaceAt", at = @At("HEAD"), cancellable = true)
    private void mixin1(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos bp = pos.offset(direction);
            BlockState bs2 = world.getBlockState(bp);
            if (bs2.isOf(ModBlocks.CHORUS_TRUNK))
                cir.setReturnValue(true);
        }

        if (world.getBlockState(pos.down()).isOf(ModBlocks.CHORUS_TRUNK))
            cir.setReturnValue(true);
    }

    @Inject(method = "withConnectionProperties", at = @At("RETURN"), cancellable = true)
    private void mixin2(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
        ChorusPlantBlock t = ((ChorusPlantBlock)(Object)this);

        BlockState bs = world.getBlockState(pos.down());
        BlockState bs2 = world.getBlockState(pos.up());
        BlockState bs3 = world.getBlockState(pos.north());
        BlockState bs4 = world.getBlockState(pos.east());
        BlockState bs5 = world.getBlockState(pos.south());
        BlockState bs6 = world.getBlockState(pos.west());

        cir.setReturnValue(
                (BlockState)(
                 (BlockState)(
                  (BlockState)(
                   (BlockState)(
                    (BlockState)(
                     (BlockState)(t.getDefaultState()
                      .with(ConnectingBlock.DOWN, bs.isOf(t) ||
                              bs.isOf(Blocks.CHORUS_FLOWER) || bs.isOf(Blocks.END_STONE) || bs.isOf(ModBlocks.CHORUS_TRUNK)))
                    ).with(ConnectingBlock.UP, bs2.isOf(t) || bs2.isOf(Blocks.CHORUS_FLOWER))
                    ).with(ConnectingBlock.NORTH, bs3.isOf(t) || bs3.isOf(Blocks.CHORUS_FLOWER) || bs3.isOf(ModBlocks.CHORUS_TRUNK))
                    ).with(ConnectingBlock.EAST, bs4.isOf(t) || bs4.isOf(Blocks.CHORUS_FLOWER) || bs4.isOf(ModBlocks.CHORUS_TRUNK))
                    ).with(ConnectingBlock.SOUTH, bs5.isOf(t) || bs5.isOf(Blocks.CHORUS_FLOWER) || bs5.isOf(ModBlocks.CHORUS_TRUNK))
                     ).with(ConnectingBlock.WEST, bs6.isOf(t) || bs6.isOf(Blocks.CHORUS_FLOWER) || bs6.isOf(ModBlocks.CHORUS_TRUNK)));
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        /* EXPLANATION: only ticks the blocks if its down and up connected */
        return state.get(ConnectingBlock.DOWN) && state.get(ConnectingBlock.UP);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        /* EXPLANATION
         * -this method will replace a chorus plant block with a chorus trunk block
        */
        if (!world.getBlockState(pos.up()).isOf(Blocks.CHORUS_FLOWER) && !world.getBlockState(pos.up()).isOf(Blocks.AIR)) {
            if (world.getBlockState(pos.down()).isOf(Blocks.END_STONE)
                || world.getBlockState(pos.down()).isOf(ModBlocks.CHORUS_TRUNK)) {
                world.setBlockState(pos, ModBlocks.CHORUS_TRUNK.getDefaultState());
                world.setBlockState(pos.up(), ((ChorusPlantBlock)(Object)this).withConnectionProperties(world, pos.up()));
            }
        }
    }
}
