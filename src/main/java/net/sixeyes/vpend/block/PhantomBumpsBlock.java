package net.sixeyes.vpend.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class PhantomBumpsBlock extends PhantomPlantBlock {

    public static final IntProperty SOUL = IntProperty.of("soul",0,2);

    public PhantomBumpsBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(SOUL, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SOUL);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack item = player.getStackInHand(hand);
        if (item.isOf(Items.ENDER_PEARL)) { // add enderman head
            world.setBlockState(pos, state.with(SOUL, 1), Block.NOTIFY_LISTENERS);
            return ActionResult.SUCCESS;
        } else if (item.isOf(Items.CREEPER_HEAD)) {
            world.setBlockState(pos, state.with(SOUL, 0), Block.NOTIFY_LISTENERS);
            return ActionResult.SUCCESS;
        } else if (item.isOf(Items.ZOMBIE_HEAD)) {
            world.setBlockState(pos, state.with(SOUL, 2), Block.NOTIFY_LISTENERS);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return state;
    }
}
