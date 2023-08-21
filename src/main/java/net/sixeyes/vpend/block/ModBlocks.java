package net.sixeyes.vpend.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.sixeyes.vpend.VPEndMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {

    // LIST OF BLOCKS
    public static List<Pair<String, Block>> BLOCKS = new ArrayList<>();

    // MISC BLOCKS

    // TERRAIN BLOCKS
    public static final Block CRACKED_END_STONE = registerBlock("cracked_end_stone", new CrackableBlock(
            FabricBlockSettings.copyOf(Blocks.END_STONE)));
    public static final Block EPILITE = registerBlock("epilite", new Block(
            FabricBlockSettings.copyOf(Blocks.END_STONE)));
    public static final Block EPILITE_STAIRS = registerBlock("epilite_stairs", new StairsBlock(
            EPILITE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.EPILITE)));
    public static final Block EPILITE_SLAB = registerBlock("epilite_slab", new SlabBlock(
            FabricBlockSettings.copyOf(ModBlocks.EPILITE)));
    public static final Block EPILITE_WALL = registerBlock("epilite_wall", new WallBlock(
            FabricBlockSettings.copyOf(ModBlocks.EPILITE).solid()));
    public static final Block MARBASE = registerBlock("marbase", new Block(
            FabricBlockSettings.copyOf(Blocks.END_STONE)));
    public static final Block MARBASE_STAIRS = registerBlock("marbase_stairs", new StairsBlock(
            MARBASE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.MARBASE)));
    public static final Block MARBASE_SLAB = registerBlock("marbase_slab", new SlabBlock(
            FabricBlockSettings.copyOf(ModBlocks.MARBASE)));
    public static final Block MARBASE_WALL = registerBlock("marbase_wall", new WallBlock(
            FabricBlockSettings.copyOf(ModBlocks.MARBASE).solid()));

    // ORE BLOCKS
    public static final Block RAW_SILICON_BLOCK = registerBlock("raw_silicon_block", new Block(
            FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block INTERCLAY_BLOCK = registerBlock("interclay_block", new Block(
            FabricBlockSettings.copyOf(Blocks.CLAY)));
    public static final Block SILICON_ORE = registerBlock("silicon_ore", new Block(
            FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block INTERCLAY_DEPOSIT = registerBlock("interclay_deposit", new Block(
            FabricBlockSettings.copyOf(Blocks.COAL_ORE)));

    // PHANTOM TROPICS BLOCKS
    public static final BlockSetType PHALM_BLOCK_SET = new BlockSetType("phalm");
    public static final WoodType PHALM = new WoodType("phalm", PHALM_BLOCK_SET);
    public static final Block PHALM_LOG = registerBlock("phalm_log", Blocks.createLogBlock(
            MapColor.CYAN, MapColor.DARK_AQUA));
    public static final Block PHALM_WOOD = registerBlock("phalm_wood",
            Blocks.createLogBlock(MapColor.CYAN, MapColor.DARK_AQUA));
    public static final Block STRIPPED_PHALM_LOG = registerBlock("stripped_phalm_log",
            Blocks.createLogBlock(MapColor.CYAN, MapColor.DARK_AQUA));
    public static final Block STRIPPED_PHALM_WOOD = registerBlock("stripped_phalm_wood",
            Blocks.createLogBlock(MapColor.CYAN, MapColor.DARK_AQUA));
    public static final Block PHALM_PLANKS = registerBlock("phalm_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)));
    public static final Block PHALM_STAIRS = registerBlock("phalm_stairs",
            new StairsBlock(PHALM_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(PHALM_PLANKS)));
    public static final Block PHALM_SLAB = registerBlock("phalm_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_SLAB)));
    public static final Block PHALM_FENCE = registerBlock("phalm_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FENCE)));
    public static final Block PHALM_FENCE_GATE = registerBlock("phalm_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FENCE_GATE), PHALM));
    public static final Block PHALM_PRESSURE_PLATE = registerBlock("phalm_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.CRIMSON_PRESSURE_PLATE), PHALM_BLOCK_SET));
    public static final Block PHALM_BUTTON = registerBlock("phalm_button",
            Blocks.createWoodenButtonBlock(PHALM_BLOCK_SET));
    public static final Block PHALM_DOOR = registerBlock("phalm_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_DOOR), PHALM_BLOCK_SET));
    public static final Block PHALM_TRAPDOOR = registerBlock("phalm_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_TRAPDOOR), PHALM_BLOCK_SET));
    public static final Block PHALM_LEAVES = registerBlock("phalm_leaves", new PhalmLeavesBlock(
            FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).luminance(15).emissiveLighting(Blocks::always)));
    public static final Block PHANTOM_SKIN = registerBlock("phantom_skin", new VoidSoilBlock(
            FabricBlockSettings.create().sounds(BlockSoundGroup.MOSS_BLOCK)));
    public static final Block PHANTOM_CRAWL = registerBlock("phantom_crawl", new PhantomCrawlBlock(
            FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN).nonOpaque()));
    public static final Block PHANTOM_END_STONE = registerBlock("phantom_end_stone", new Block(
            FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.MOSS_BLOCK)));
    public static final Block PHANTOM_BLADES = registerBlock("phantom_blades", new PhantomPlantBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable()
                    .pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));

    public static final Block PHANTOM_BUMPS = registerBlock("phantom_bumps", new PhantomBumpsBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable()
                    .pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));
    public static final Block PHANTOM_THICKET = registerBlock("phantom_thicket", new TallPhantomPlantBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.TEAL).noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable()
                    .pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));
    public static final Block FRUIT_BUSH = registerBlock("fruit_bush", new FruitBushBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).breakInstantly()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));

    // VOID-ZONE BLOCKS
    public static final Block VOID_SOIL = registerBlock("void_soil", new VoidSoilBlock(FabricBlockSettings.copyOf(Blocks.SOUL_SOIL).luminance(-15)));

    // ANCIENT PEAKS BLOCKS
    public static final Block COLD_END_STONE = registerBlock("cold_end_stone", new Block(
            FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.POWDER_SNOW)));

    // ECHOEING WASTELANDS BLOCKS
    public static final BlockSetType CHORUS_BLOCK_SET = new BlockSetType("chorus");
    public static final WoodType CHORUS = new WoodType("chorus", CHORUS_BLOCK_SET);
    public static final Block ECHOEING_END_STONE = registerBlock("echoeing_end_stone", new Block(
            FabricBlockSettings.copyOf(Blocks.END_STONE).sounds(BlockSoundGroup.SCULK).luminance(10)));
    public static final Block CHOIR_GROWTH = registerBlock("choir_growth", new EchoeingPlantBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.SCULK_VEIN).offset(AbstractBlock.OffsetType.XYZ).burnable()
                    .pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));
    public static final Block CHOIR_BUBBLES = registerBlock("choir_bubbles", new ChoirBubblesBlock(
            FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN).sounds(BlockSoundGroup.SCULK_VEIN).nonOpaque().luminance(10)));
    public static final Block CHORUS_TRUNK = registerBlock("chorus_trunk",
            Blocks.createLogBlock(MapColor.PALE_PURPLE, MapColor.PALE_PURPLE));
    public static final Block STRIPPED_CHORUS_TRUNK = registerBlock("stripped_chorus_trunk",
            Blocks.createLogBlock(MapColor.PALE_PURPLE, MapColor.PALE_PURPLE));
    public static final Block CHORUS_PLANKS = registerBlock("chorus_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)));
    public static final Block CHORUS_STAIRS = registerBlock("chorus_stairs",
            new StairsBlock(CHORUS_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(CHORUS_PLANKS)));
    public static final Block CHORUS_SLAB = registerBlock("chorus_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_SLAB)));
    public static final Block CHORUS_FENCE = registerBlock("chorus_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FENCE)));
    public static final Block CHORUS_FENCE_GATE = registerBlock("chorus_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FENCE_GATE), CHORUS));
    public static final Block CHORUS_PRESSURE_PLATE = registerBlock("chorus_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.CRIMSON_PRESSURE_PLATE), CHORUS_BLOCK_SET));
    public static final Block CHORUS_BUTTON = registerBlock("chorus_button",
            Blocks.createWoodenButtonBlock(CHORUS_BLOCK_SET));
    public static final Block CHORUS_DOOR = registerBlock("chorus_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_DOOR), CHORUS_BLOCK_SET));
    public static final Block CHORUS_TRAPDOOR = registerBlock("chorus_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_TRAPDOOR), CHORUS_BLOCK_SET));

    // METHODS
    private static Block registerBlock(String name, Block block) {
        BLOCKS.add(new Pair<>(name, block));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(VPEndMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(VPEndMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {

        VPEndMod.LOGGER.info("Registering Mod Blocks " + VPEndMod.MOD_ID);
    }
}
