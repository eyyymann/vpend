package net.sixeyes.vpend.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.VPEndMod;

public class ModTags {
    public static final TagKey<Block> PHANTOM_TROPICS_GROUND = blockTagOf("phantom_tropics_ground");
    public static final TagKey<Block> ECHOEING_WASTELANDS_GROUND = blockTagOf("echoeing_wastelands_ground");
    public static final TagKey<Block> END_CRATER_REPLACEABLE = blockTagOf("end_crater_replaceable");

    private static TagKey<Block> blockTagOf(String name) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(VPEndMod.MOD_ID, name));
    }

    public static void registerModTags() {

        VPEndMod.LOGGER.info("Registering Mod Tags " + VPEndMod.MOD_ID);
    }
}
