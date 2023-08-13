package net.sixeyes.vpend.world.trees;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.sixeyes.vpend.VPEndMod;
import net.sixeyes.vpend.mixin.FoliagePlacerTypeInvoker;
import net.sixeyes.vpend.mixin.TrunkPlacerTypeInvoker;

public class ModTrees {

    public static final TrunkPlacerType<PalmTrunkPlacer> PALM_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister(
            "vpend:palm_trunk_placer", PalmTrunkPlacer.CODEC);

    public static final TrunkPlacerType<BigPalmTrunkPlacer> BIG_PALM_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister(
            "vpend:big_palm_trunk_placer", BigPalmTrunkPlacer.CODEC);

    public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister(
            "vpend:palm_foliage_placer", PalmFoliagePlacer.CODEC);

    public static void registerModTrees() {

        VPEndMod.LOGGER.info("Registering Mod Trunk Placers for " + VPEndMod.MOD_ID);
    }
}
