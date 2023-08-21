package net.sixeyes.vpend.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;


public class CrackableBlock extends Block {

    public static final IntProperty CRACK_STAGE = IntProperty.of("crack_stage",1,4);

    public CrackableBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(CRACK_STAGE, 1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CRACK_STAGE);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient()) {
            int stage = state.get(CRACK_STAGE);
            if (stage < 4) {
                Random random = world.getRandom();
                if (random.nextInt(4000) < stage*50) {
                    BlockState blockState = (BlockState)state.with(CRACK_STAGE, stage + 1);
                    world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
                }
            }
            if (stage == 4) {
                Random random = world.getRandom();
                if (random.nextInt(stage*100) > stage*50) {
                    world.breakBlock(pos, true, entity);
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
