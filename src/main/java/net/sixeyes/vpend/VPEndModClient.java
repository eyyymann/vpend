package net.sixeyes.vpend;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.sixeyes.vpend.block.ModBlocks;

public class VPEndModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // adding select blocks to the cutout render layer
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PHANTOM_CRAWL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PHANTOM_BLADES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PHANTOM_BUMPS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PHANTOM_THICKET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRUIT_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHOIR_GROWTH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHOIR_BUBBLES, RenderLayer.getCutout());
    }
}
