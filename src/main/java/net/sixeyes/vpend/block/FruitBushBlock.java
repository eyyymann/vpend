package net.sixeyes.vpend.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.sixeyes.vpend.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class FruitBushBlock extends Block {
    // Explanation for the fruit property
    // 0 - means it will never produce fruit
    // 1 - means it is currently fruitless but produces oranges
    // 2 - means it is currently producing oranges
    // 3 - means it is currently fruitless but produces bananas
    // 4 - means it is currently producing bananas
    // 5 - means it is currently fruitless but produces peaches
    // 6 - means it is currently producing peaches
    public static final IntProperty FRUIT = IntProperty.of("fruit",0,6);

    public FruitBushBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FRUIT, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FRUIT);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        /* EXPLANATION: only ticks the blocks if its fruit property is uneven */
        return state.get(FRUIT) % 2 == 1;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        /* EXPLANATION
        * -this method causes the blocks to tick and
        * -after a random amount of time bear fruit
        * -which shifts it into its appropriate
        * -fruit bearing state
        * */
        int i = state.get(FRUIT);
        if (random.nextInt(50) == 0) {
            BlockState blockState = (BlockState)state.with(FRUIT, i + 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        /* EXPLANATION
         * -the fruitStateToEvents is a hashmap made to shorten the amount of similar code
         * -it's key is the appropriate fruit property state
         * -it's value is a list containing
         * --the maximum amount of items it will drop
         * --the Item it should drop
         *
         * -the onUse method is divided into two scenarios
         * --one where the player uses shears, producing lots of fruit and preserving the fruit property
         * --one where the player uses their bare hand,
         * producing some fruit and destroying any future fruit bearing properties
         *  */
        if (!world.isClient()) {
            Map<Integer, List<Object>> fruitStateToEvents = new HashMap<>() {{
                put(2, new ArrayList<>() {{
                    add(3);
                    add(ModItems.BANANA);
                }});
                put(4, new ArrayList<>() {{
                    add(3);
                    add(ModItems.ORANGE);
                }});
                put(6, new ArrayList<>() {{
                    add(4);
                    add(ModItems.PEACH);
                }});
            }};

            int fruit = state.get(FRUIT), i;

            if (player.getStackInHand(hand).isOf(Items.SHEARS)) {
                switch (fruit) {
                    case 0, 1, 3, 5:
                        return ActionResult.FAIL;
                    case 2, 4, 6:
                        i = 1 + world.random.nextInt(
                                (Integer)fruitStateToEvents.get(fruit).get(0));
                        FruitBushBlock.dropStack(world, pos, new ItemStack(
                                (Item)fruitStateToEvents.get(fruit).get(1), i));
                        world.setBlockState(pos,
                                state.with(FRUIT, fruit-1),
                                Block.NOTIFY_LISTENERS);
                        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos,
                                GameEvent.Emitter.of(player,
                                        state.with(FRUIT, fruit-1)));
                        return ActionResult.SUCCESS;
                }
            } else if (player.getStackInHand(hand).isEmpty()) {
                switch (fruit) {
                    case 0, 1, 3, 5:
                        return ActionResult.FAIL;
                    case 2, 4, 6:
                        i = 1 + world.random.nextInt(
                                (Integer)fruitStateToEvents.get(fruit).get(0)-2);
                        FruitBushBlock.dropStack(world, pos, new ItemStack(
                                (Item)fruitStateToEvents.get(fruit).get(1), i));
                        world.setBlockState(pos,
                                state.with(FRUIT, 0), Block.NOTIFY_LISTENERS);
                        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos,
                                GameEvent.Emitter.of(player, state.with(FRUIT, 0)));
                        return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        /* EXPLANATION: only allows the blocks to be placed on phantom skin or phantom end stone or other fruit bushes only if player is in survival */
        BlockState below = world.getBlockState(pos.offset(Direction.Axis.Y, -1));
        return below.isOf(ModBlocks.PHANTOM_SKIN) || below.isOf(ModBlocks.PHANTOM_END_STONE) || below.isOf(ModBlocks.FRUIT_BUSH);
    }

    @Override
    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return 1;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return state;
    }
}
