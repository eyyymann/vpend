package net.sixeyes.vpend.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.block.CrackableBlock;
import net.sixeyes.vpend.block.FruitBushBlock;
import net.sixeyes.vpend.block.ModBlocks;
import net.sixeyes.vpend.item.ModItems;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput generator) {
        super(generator);
    }

    public final void registerEndBottomCustomTop(BlockStateModelGenerator blockStateModelGenerator, Block block, Block optionalTop, boolean seperateTop) {
        Identifier id = TextureMap.getId(block);
        if (seperateTop) {
            id = TextureMap.getId(optionalTop);
        }

        TextureMap textureMap = new TextureMap()
                .put(TextureKey.BOTTOM, TextureMap.getId(Blocks.END_STONE))
                .put(TextureKey.TOP, id)
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"));

        blockStateModelGenerator.blockStateCollector.
                accept(BlockStateModelGenerator.createSingletonBlockState(
                        block, Models.CUBE_BOTTOM_TOP.upload(
                                block, textureMap, blockStateModelGenerator.modelCollector)));
    }

    private void registerCrackedEndStone(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.CRACKED_END_STONE)
                        .coordinate(
                                BlockStateVariantMap.create(CrackableBlock.CRACK_STAGE)
                                        .register((Integer)1, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.CRACKED_END_STONE, "", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)2, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.CRACKED_END_STONE, "1", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)3, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.CRACKED_END_STONE, "2", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)4, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.CRACKED_END_STONE, "3", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                        )

        );

    }

    private void registerFruitBush(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.FRUIT_BUSH)
                        .coordinate(
                                BlockStateVariantMap.create(FruitBushBlock.FRUIT)
                                        .register((Integer)0, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.FRUIT_BUSH, "", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)1, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.FRUIT_BUSH, "_banana1", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)2, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.FRUIT_BUSH, "_banana2", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)3, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.FRUIT_BUSH, "_orange1", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)4, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.FRUIT_BUSH, "_orange2", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)5, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.FRUIT_BUSH, "_peach1", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer)6, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.FRUIT_BUSH, "_peach2", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                        )

        );

    }

    private void registerChorusPlant(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerItemModel(Blocks.CHORUS_PLANT.asItem());
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // add the rest
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EPILITE)
                .stairs(ModBlocks.EPILITE_STAIRS)
                .slab(ModBlocks.EPILITE_SLAB)
                .wall(ModBlocks.EPILITE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBASE)
                .stairs(ModBlocks.MARBASE_STAIRS)
                .slab(ModBlocks.MARBASE_SLAB)
                .wall(ModBlocks.MARBASE_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SILICON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INTERCLAY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILICON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INTERCLAY_DEPOSIT);

        blockStateModelGenerator.registerLog(ModBlocks.PHALM_LOG)
                .log(ModBlocks.PHALM_LOG).wood(ModBlocks.PHALM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PHALM_LOG)
                .log(ModBlocks.STRIPPED_PHALM_LOG).wood(ModBlocks.STRIPPED_PHALM_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PHALM_PLANKS)
                .button(ModBlocks.PHALM_BUTTON)
                .stairs(ModBlocks.PHALM_STAIRS)
                .slab(ModBlocks.PHALM_SLAB)
                .fence(ModBlocks.PHALM_FENCE)
                .fenceGate(ModBlocks.PHALM_FENCE_GATE)
                .pressurePlate(ModBlocks.PHALM_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.PHALM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PHALM_TRAPDOOR);
        blockStateModelGenerator.registerSingleton(ModBlocks.PHALM_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.registerWallPlant(ModBlocks.PHANTOM_CRAWL);

        registerEndBottomCustomTop(blockStateModelGenerator, ModBlocks.PHANTOM_END_STONE, ModBlocks.PHANTOM_SKIN, true);
        registerEndBottomCustomTop(blockStateModelGenerator, ModBlocks.ECHOEING_END_STONE, null, false);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COLD_END_STONE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PHANTOM_SKIN);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PHANTOM_BLADES, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PHANTOM_BUMPS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.PHANTOM_THICKET, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_SOIL);
        registerCrackedEndStone(blockStateModelGenerator);
        registerFruitBush(blockStateModelGenerator);

        blockStateModelGenerator.registerTintableCross(ModBlocks.CHOIR_GROWTH, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerWallPlant(ModBlocks.CHOIR_BUBBLES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHORUS_TRUNK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STRIPPED_CHORUS_TRUNK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHORUS_PLANKS)
                .button(ModBlocks.CHORUS_BUTTON)
                .stairs(ModBlocks.CHORUS_STAIRS)
                .slab(ModBlocks.CHORUS_SLAB)
                .fence(ModBlocks.CHORUS_FENCE)
                .fenceGate(ModBlocks.CHORUS_FENCE_GATE)
                .pressurePlate(ModBlocks.CHORUS_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.CHORUS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CHORUS_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEACH, Models.GENERATED);
        itemModelGenerator.register(ModItems.MESOGLEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SILICON, Models.GENERATED);
    }
}
