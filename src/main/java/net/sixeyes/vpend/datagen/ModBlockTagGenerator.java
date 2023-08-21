package net.sixeyes.vpend.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {


    private static final TagKey<Block> END_GROUND = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("vpend:end_ground"));
    private static final TagKey<Block> ECHOEING_WASTELANDS_GROUND = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("vpend:echoeing_wastelands_ground"));
    private static final TagKey<Block> PHANTOM_TROPICS_GROUND = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("vpend:phantom_tropics_ground"));
    private static final TagKey<Block> ANCIENT_PEAKS_GROUND = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("vpend:ancient_peaks_ground"));
    private static final TagKey<Block> END_CRATER_REPLACEABLE = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("vpend:end_crater_replaceable"));
    private static final TagKey<Block> PHALM_WOODSET = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("vpend:phalm_woodset"));
    private static final TagKey<Block> CHORUS_WOODSET = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("vpend:chorus_woodset"));

    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // END GROUND
        getOrCreateTagBuilder(END_GROUND)
                .add(ModBlocks.CRACKED_END_STONE)
                .add(Blocks.END_STONE)
                .add(ModBlocks.EPILITE)
                .add(ModBlocks.MARBASE);

        // ECHOEING WASTELANDS GROUND
        getOrCreateTagBuilder(ECHOEING_WASTELANDS_GROUND)
                .add(ModBlocks.ECHOEING_END_STONE)
                .addTag(END_GROUND);

        // PHANTOM TROPICS GROUND
        getOrCreateTagBuilder(PHANTOM_TROPICS_GROUND)
                .add(ModBlocks.PHANTOM_END_STONE)
                .add(ModBlocks.PHANTOM_SKIN)
                .addTag(END_GROUND);

        // ANCIENT PEAKS GROUND
        getOrCreateTagBuilder(ANCIENT_PEAKS_GROUND)
                .add(ModBlocks.COLD_END_STONE)
                .addTag(END_GROUND);

        // END CRATER REPLACEABLE
        getOrCreateTagBuilder(END_CRATER_REPLACEABLE)
                .add(Blocks.END_STONE);

        // PHALM WOODSET
        getOrCreateTagBuilder(PHALM_WOODSET)
                .add(ModBlocks.PHALM_LOG)
                .add(ModBlocks.PHALM_WOOD)
            .add(ModBlocks.STRIPPED_PHALM_LOG)
            .add(ModBlocks.STRIPPED_PHALM_WOOD)
            .add(ModBlocks.PHALM_PLANKS)
            .add(ModBlocks.PHALM_STAIRS)
            .add(ModBlocks.PHALM_SLAB)
            .add(ModBlocks.PHALM_DOOR)
            .add(ModBlocks.PHALM_TRAPDOOR)
            .add(ModBlocks.PHALM_BUTTON)
            .add(ModBlocks.PHALM_PRESSURE_PLATE)
            .add(ModBlocks.PHALM_FENCE)
            .add(ModBlocks.PHALM_FENCE_GATE);

        // PHALM WOODSET
        getOrCreateTagBuilder(CHORUS_WOODSET)
                .add(ModBlocks.CHORUS_TRUNK)
                .add(ModBlocks.STRIPPED_CHORUS_TRUNK)
                .add(ModBlocks.CHORUS_PLANKS)
                .add(ModBlocks.CHORUS_STAIRS)
                .add(ModBlocks.CHORUS_SLAB)
                .add(ModBlocks.CHORUS_DOOR)
                .add(ModBlocks.CHORUS_TRAPDOOR)
                .add(ModBlocks.CHORUS_BUTTON)
                .add(ModBlocks.CHORUS_PRESSURE_PLATE)
                .add(ModBlocks.CHORUS_FENCE)
                .add(ModBlocks.CHORUS_FENCE_GATE);

        // NEEDS STONE TOOLS
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.FRUIT_BUSH)
                .add(ModBlocks.CRACKED_END_STONE)
                .add(ModBlocks.ECHOEING_END_STONE)
                .add(ModBlocks.PHANTOM_END_STONE)
                .add(ModBlocks.COLD_END_STONE)
                .add(ModBlocks.EPILITE)
                .add(ModBlocks.EPILITE_STAIRS)
                .add(ModBlocks.EPILITE_SLAB)
                .add(ModBlocks.EPILITE_WALL)
                .add(ModBlocks.MARBASE)
                .add(ModBlocks.MARBASE_STAIRS)
                .add(ModBlocks.MARBASE_SLAB)
                .add(ModBlocks.MARBASE_WALL);

        // NEEDS IRON TOOLS

        // NEEDS DIAMOND TOOLS
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.RAW_SILICON_BLOCK);

        // NEEDS AXES
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .addTag(PHALM_WOODSET)
                .addTag(CHORUS_WOODSET)
                .add(Blocks.CHORUS_PLANT);

        // NEEDS PICKAXES
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CRACKED_END_STONE)
                .add(ModBlocks.EPILITE)
                .add(ModBlocks.EPILITE_STAIRS)
                .add(ModBlocks.EPILITE_SLAB)
                .add(ModBlocks.EPILITE_WALL)
                .add(ModBlocks.MARBASE)
                .add(ModBlocks.MARBASE_STAIRS)
                .add(ModBlocks.MARBASE_SLAB)
                .add(ModBlocks.MARBASE_WALL)
                .add(ModBlocks.RAW_SILICON_BLOCK)
                .add(ModBlocks.INTERCLAY_BLOCK)
                .add(ModBlocks.SILICON_ORE)
                .add(ModBlocks.INTERCLAY_DEPOSIT)
                .add(ModBlocks.COLD_END_STONE)
                .add(ModBlocks.PHANTOM_END_STONE)
                .add(ModBlocks.ECHOEING_END_STONE);

        // NEEDS SHOVELS
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.PHANTOM_SKIN)
                .add(ModBlocks.VOID_SOIL);

        // NEEDS HOES
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.PHALM_LEAVES)
                .add(ModBlocks.PHANTOM_CRAWL)
                .add(ModBlocks.PHANTOM_BLADES)
                .add(ModBlocks.PHANTOM_BUMPS)
                .add(ModBlocks.PHANTOM_THICKET)
                .add(ModBlocks.FRUIT_BUSH)
                .add(ModBlocks.CHOIR_GROWTH)
                .add(ModBlocks.CHOIR_BUBBLES);

        // WOODSET TAGS
        getOrCreateTagBuilder(BlockTags.LOGS).add(ModBlocks.PHALM_LOG)
            .add(ModBlocks.STRIPPED_PHALM_LOG)
            .add(ModBlocks.STRIPPED_PHALM_WOOD)
            .add(ModBlocks.STRIPPED_PHALM_LOG)
            .add(ModBlocks.CHORUS_TRUNK)
            .add(ModBlocks.STRIPPED_CHORUS_TRUNK);
        getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.PHALM_LEAVES);
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.PHALM_PLANKS)
                .add(ModBlocks.CHORUS_PLANKS);
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.PHALM_STAIRS)
                .add(ModBlocks.CHORUS_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.PHALM_SLAB)
                .add(ModBlocks.CHORUS_SLAB);
        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.PHALM_DOOR)
                .add(ModBlocks.CHORUS_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.PHALM_TRAPDOOR)
                .add(ModBlocks.CHORUS_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.PHALM_BUTTON)
                .add(ModBlocks.CHORUS_BUTTON);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.PHALM_PRESSURE_PLATE)
                .add(ModBlocks.CHORUS_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.PHALM_FENCE)
                .add(ModBlocks.CHORUS_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PHALM_FENCE_GATE)
                .add(ModBlocks.CHORUS_FENCE_GATE);

        // WALLS
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.EPILITE_WALL)
                .add(ModBlocks.MARBASE_WALL);
    }
}
