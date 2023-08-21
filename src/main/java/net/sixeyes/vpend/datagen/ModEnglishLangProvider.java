package net.sixeyes.vpend.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Pair;
import net.sixeyes.vpend.block.ModBlocks;
import net.sixeyes.vpend.item.ModItems;
import net.sixeyes.vpend.status_effect.ModStatusEffects;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ModEnglishLangProvider extends FabricLanguageProvider {

    public ModEnglishLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for (Pair<String, Item> pair : ModItems.ITEMS) {
            String[] strings = pair.getLeft().split("\\_", 0);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = StringUtils.capitalize(strings[i]);
            }
            translationBuilder.add(pair.getRight(),
                    String.join(" ", strings));
        }

        for (Pair<String, Block> pair : ModBlocks.BLOCKS) {
            String[] strings = pair.getLeft().split("\\_", 0);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = StringUtils.capitalize(strings[i]);
            }
            translationBuilder.add(pair.getRight(),
                    String.join(" ", strings));
        }

        translationBuilder.add("itemgroup.items", "Vanilla+ End Items");
        translationBuilder.add("itemgroup.blocks", "Vanilla+ End Blocks");

        translationBuilder.add(ModStatusEffects.IMMUNITY, "Immunity");
        translationBuilder.add(ModStatusEffects.SAVOURY, "Savoury");
        translationBuilder.add(ModStatusEffects.PHANTOM, "Phantom");

        // add biomes translations
    }
}
