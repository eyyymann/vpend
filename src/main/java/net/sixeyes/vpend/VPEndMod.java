package net.sixeyes.vpend;

import net.fabricmc.api.ModInitializer;
import net.sixeyes.vpend.block.ModBlocks;
import net.sixeyes.vpend.item.ModItemGroup;
import net.sixeyes.vpend.item.ModItems;
import net.sixeyes.vpend.particle.ModParticles;
import net.sixeyes.vpend.registry.ModTags;
import net.sixeyes.vpend.status_effect.ModStatusEffects;
import net.sixeyes.vpend.world.features.ModFeatures;
import net.sixeyes.vpend.world.trees.ModTrees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VPEndMod implements ModInitializer {
	public static final String MOD_ID = "vpend";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModStatusEffects.registerModStatusEffects();
		ModBlocks.registerModBlocks();
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModFeatures.registerModFeatures();
		ModTrees.registerModTrees();
		ModTags.registerModTags();
		ModParticles.registerModParticles();
		LOGGER.info("Hello Fabric world!");
	}
}