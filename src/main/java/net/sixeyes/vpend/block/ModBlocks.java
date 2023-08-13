package net.sixeyes.vpend.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.VPEndMod;

public class ModBlocks {

    // TERRAIN BLOCKS
    public static final Block RAW_SILICON = registerBlock("raw_silicon", new Block(
            FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block INTERCLAY = registerBlock("interclay", new Block(
            FabricBlockSettings.copyOf(Blocks.CLAY)));
    public static final Block SILICON_ORE = registerBlock("silicon_ore", new Block(
            FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block INTERCLAY_DEPOSIT = registerBlock("interclay_deposit", new Block(
            FabricBlockSettings.copyOf(Blocks.COAL_ORE)));

    // PHANTOM TROPICS BLOCKS
    public static final Block PHALM_LOG = registerBlock("phalm_log", Blocks.createLogBlock(
            MapColor.CYAN, MapColor.DARK_AQUA));
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
    public static final Block CRACKED_END_STONE = registerBlock("cracked_end_stone", new Block(
            FabricBlockSettings.copyOf(Blocks.END_STONE)));
    public static final Block ECHOEING_END_STONE = registerBlock("echoeing_end_stone", new Block(
            FabricBlockSettings.copyOf(Blocks.END_STONE).luminance(10)));
    public static final Block CHOIR_GROWTH = registerBlock("choir_growth", new EchoeingPlantBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable()
                    .pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));
    public static final Block CHOIR_BUBBLES = registerBlock("choir_bubbles", new ChoirBubblesBlock(
            FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN).nonOpaque().luminance(6)));

    // METHODS
    private static Block registerBlock(String name, Block block) {
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
