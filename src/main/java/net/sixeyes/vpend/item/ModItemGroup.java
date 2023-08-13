package net.sixeyes.vpend.item;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
                        entries.add(ModItems.MESOGLEA);
                        entries.add(ModItems.BANANA);
                        entries.add(ModItems.ORANGE);
                        entries.add(ModItems.PEACH);
                    }).build());

    public static final ItemGroup BLOCKS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(VPEndMod.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.PHALM_LOG))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAW_SILICON);
                        entries.add(ModBlocks.INTERCLAY);
                        entries.add(ModBlocks.SILICON_ORE);
                        entries.add(ModBlocks.INTERCLAY_DEPOSIT);

                        entries.add(ModBlocks.PHALM_LOG);
                        entries.add(ModBlocks.PHALM_LEAVES);
                        entries.add(ModBlocks.PHANTOM_SKIN);
                        entries.add(ModBlocks.PHANTOM_CRAWL);
                        entries.add(ModBlocks.PHANTOM_END_STONE);
                        entries.add(ModBlocks.PHANTOM_BLADES);
                        entries.add(ModBlocks.PHANTOM_BUMPS);
                        entries.add(ModBlocks.PHANTOM_THICKET);
                        entries.add(ModBlocks.FRUIT_BUSH);

                        entries.add(ModBlocks.VOID_SOIL);

                        entries.add(ModBlocks.COLD_END_STONE);

                        entries.add(ModBlocks.CRACKED_END_STONE);
                        entries.add(ModBlocks.ECHOEING_END_STONE);
                        entries.add(ModBlocks.CHOIR_GROWTH);
                        entries.add(ModBlocks.CHOIR_BUBBLES);
                    }).build());

    public static void registerItemGroups() {
        VPEndMod.LOGGER.info("Registering Item Group for " + VPEndMod.MOD_ID);
    }
}
