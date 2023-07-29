package net.sixeyes.vpend.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.VPEndMod;

import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final Block PHALM_LOG = registerBlock("phalm_log", Blocks.createLogBlock(MapColor.CYAN, MapColor.DARK_AQUA));
    public static final Block PHALM_LEAVES = registerBlock("phalm_leaves", Blocks.createLeavesBlock(BlockSoundGroup.GRASS));
    public static final Block VOID_SOIL = registerBlock("void_soil", new VoidSoilBlock(FabricBlockSettings.copyOf(Blocks.SOUL_SOIL).luminance(7)));
    public static final Block PHANTOM_SKIN = registerBlock("phantom_skin", new VoidSoilBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.SLIME)));
    public static final Block PHANTOM_CRAWL = registerBlock("phantom_crawl", new PhantomCrawlBlock(FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN)));

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
