package net.sixeyes.vpend.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Pair;
import net.sixeyes.vpend.VPEndMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.block.ModBlocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    // LIST OF BLOCKS
    public static List<Pair<String, Item>> ITEMS = new ArrayList<>();

    public static final Item MESOGLEA = registerItem("mesoglea", new MesogleaItem(new FabricItemSettings()));
    public static final Item BANANA = registerItem("banana", new BananaItem(new Item.Settings().food(BananaItem.BANANA)));
    public static final Item ORANGE = registerItem("orange", new OrangeItem(new Item.Settings().food(OrangeItem.ORANGE)));
    public static final Item PEACH = registerItem("peach", new PeachItem(new Item.Settings().food(PeachItem.PEACH)));
    public static final Item RAW_SILICON = registerItem("raw_silicon", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        ITEMS.add(new Pair<>(name, item));
        return Registry.register(Registries.ITEM, new Identifier(VPEndMod.MOD_ID, name), item);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(VPEndMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModItems() {
        VPEndMod.LOGGER.info("Registering Mod Items for " + VPEndMod.MOD_ID);
    }

}
