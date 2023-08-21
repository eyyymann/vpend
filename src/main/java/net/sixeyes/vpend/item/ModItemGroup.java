package net.sixeyes.vpend.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Pair;
import net.sixeyes.vpend.VPEndMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup ITEMS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(VPEndMod.MOD_ID, "items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.items"))
                    .icon(() -> new ItemStack(ModItems.MESOGLEA))
                    .entries((displayContext, entries) -> {
                        for (Pair<String, Item> pair : ModItems.ITEMS) {
                            entries.add(pair.getRight());
                        }
                    }).build());

    public static final ItemGroup BLOCKS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(VPEndMod.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.PHALM_LOG))
                    .entries((displayContext, entries) -> {
                        entries.add(Blocks.END_STONE);
                        for (Pair<String, Block> pair : ModBlocks.BLOCKS) {
                            entries.add(pair.getRight());
                        }
                    }).build());

    public static void registerItemGroups() {
        VPEndMod.LOGGER.info("Registering Item Group for " + VPEndMod.MOD_ID);
    }
}
