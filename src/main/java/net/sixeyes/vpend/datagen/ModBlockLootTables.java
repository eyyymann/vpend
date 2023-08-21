package net.sixeyes.vpend.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.sixeyes.vpend.block.ModBlocks;
import net.sixeyes.vpend.item.ModItems;

public class ModBlockLootTables extends FabricBlockLootTableProvider {
    public ModBlockLootTables(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CRACKED_END_STONE, drops(ModBlocks.CRACKED_END_STONE.asItem()));
        addDrop(ModBlocks.EPILITE, drops(ModBlocks.EPILITE.asItem()));
        addDrop(ModBlocks.EPILITE_STAIRS, drops(ModBlocks.EPILITE_STAIRS.asItem()));
        addDrop(ModBlocks.EPILITE_SLAB, drops(ModBlocks.EPILITE_SLAB.asItem()));
        addDrop(ModBlocks.EPILITE_WALL, drops(ModBlocks.EPILITE_WALL.asItem()));
        addDrop(ModBlocks.MARBASE, drops(ModBlocks.MARBASE.asItem()));
        addDrop(ModBlocks.MARBASE_STAIRS, drops(ModBlocks.MARBASE_STAIRS.asItem()));
        addDrop(ModBlocks.MARBASE_SLAB, drops(ModBlocks.MARBASE_SLAB.asItem()));
        addDrop(ModBlocks.MARBASE_WALL, drops(ModBlocks.MARBASE_WALL.asItem()));

        addDrop(ModBlocks.RAW_SILICON_BLOCK, drops(ModBlocks.RAW_SILICON_BLOCK.asItem()));
        addDrop(ModBlocks.INTERCLAY_BLOCK, drops(ModBlocks.INTERCLAY_BLOCK.asItem()));
        addDrop(ModBlocks.SILICON_ORE, drops(ModItems.RAW_SILICON));
        addDrop(ModBlocks.INTERCLAY_DEPOSIT, drops(ModBlocks.INTERCLAY_DEPOSIT.asItem()));

        addDrop(ModBlocks.PHALM_LOG, drops(ModBlocks.PHALM_LOG.asItem()));
        addDrop(ModBlocks.PHALM_WOOD, drops(ModBlocks.PHALM_WOOD.asItem()));
        addDrop(ModBlocks.STRIPPED_PHALM_LOG, drops(ModBlocks.STRIPPED_PHALM_LOG.asItem()));
        addDrop(ModBlocks.STRIPPED_PHALM_WOOD, drops(ModBlocks.STRIPPED_PHALM_WOOD.asItem()));
        addDrop(ModBlocks.PHALM_PLANKS, drops(ModBlocks.PHALM_PLANKS.asItem()));
        addDrop(ModBlocks.PHALM_STAIRS, drops(ModBlocks.PHALM_STAIRS.asItem()));
        addDrop(ModBlocks.PHALM_SLAB, drops(ModBlocks.PHALM_SLAB.asItem()));
        addDrop(ModBlocks.PHALM_FENCE, drops(ModBlocks.PHALM_FENCE.asItem()));
        addDrop(ModBlocks.PHALM_FENCE_GATE, drops(ModBlocks.PHALM_FENCE_GATE.asItem()));
        addDrop(ModBlocks.PHALM_PRESSURE_PLATE, drops(ModBlocks.PHALM_PRESSURE_PLATE.asItem()));
        addDrop(ModBlocks.PHALM_BUTTON, drops(ModBlocks.PHALM_BUTTON.asItem()));
        addDrop(ModBlocks.PHALM_DOOR, drops(ModBlocks.PHALM_DOOR.asItem()));
        addDrop(ModBlocks.PHALM_TRAPDOOR, drops(ModBlocks.PHALM_TRAPDOOR.asItem()));
        addDrop(ModBlocks.PHALM_LEAVES, drops(ModBlocks.PHALM_LEAVES.asItem()));

        addDrop(ModBlocks.PHANTOM_SKIN, drops(ModBlocks.PHANTOM_SKIN.asItem()));
        addDrop(ModBlocks.PHANTOM_CRAWL, drops(ModBlocks.PHANTOM_CRAWL.asItem()));
        addDrop(ModBlocks.PHANTOM_END_STONE, drops(ModBlocks.PHANTOM_END_STONE.asItem()));
        addDrop(ModBlocks.PHANTOM_BLADES, drops(ModBlocks.PHANTOM_BLADES.asItem()));
        addDrop(ModBlocks.PHANTOM_BUMPS, drops(ModBlocks.PHANTOM_BUMPS.asItem()));
        addDrop(ModBlocks.PHANTOM_THICKET, drops(ModBlocks.PHANTOM_THICKET.asItem()));
        addDrop(ModBlocks.FRUIT_BUSH, drops(ModBlocks.FRUIT_BUSH.asItem()));

        addDrop(ModBlocks.VOID_SOIL, drops(ModBlocks.VOID_SOIL.asItem()));

        addDrop(ModBlocks.COLD_END_STONE, drops(ModBlocks.COLD_END_STONE.asItem()));

        addDrop(ModBlocks.ECHOEING_END_STONE, drops(ModBlocks.ECHOEING_END_STONE.asItem()));
        addDrop(ModBlocks.CHORUS_TRUNK, drops(ModBlocks.CHORUS_TRUNK.asItem()));
        addDrop(ModBlocks.STRIPPED_CHORUS_TRUNK, drops(ModBlocks.STRIPPED_CHORUS_TRUNK.asItem()));
        addDrop(ModBlocks.CHORUS_PLANKS, drops(ModBlocks.CHORUS_PLANKS.asItem()));
        addDrop(ModBlocks.CHORUS_STAIRS, drops(ModBlocks.CHORUS_STAIRS.asItem()));
        addDrop(ModBlocks.CHORUS_SLAB, drops(ModBlocks.CHORUS_SLAB.asItem()));
        addDrop(ModBlocks.CHORUS_FENCE, drops(ModBlocks.CHORUS_FENCE.asItem()));
        addDrop(ModBlocks.CHORUS_FENCE_GATE, drops(ModBlocks.CHORUS_FENCE_GATE.asItem()));
        addDrop(ModBlocks.CHORUS_PRESSURE_PLATE, drops(ModBlocks.CHORUS_PRESSURE_PLATE.asItem()));
        addDrop(ModBlocks.CHORUS_BUTTON, drops(ModBlocks.CHORUS_BUTTON.asItem()));
        addDrop(ModBlocks.CHORUS_DOOR, drops(ModBlocks.CHORUS_DOOR.asItem()));
        addDrop(ModBlocks.CHORUS_TRAPDOOR, drops(ModBlocks.CHORUS_TRAPDOOR.asItem()));
        addDrop(ModBlocks.CHOIR_GROWTH, drops(ModBlocks.CHOIR_GROWTH.asItem()));
        addDrop(ModBlocks.CHOIR_BUBBLES, drops(ModBlocks.CHOIR_BUBBLES.asItem()));
    }
}
