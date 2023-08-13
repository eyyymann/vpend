package net.sixeyes.vpend.item;

import net.sixeyes.vpend.VPEndMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item MESOGLEA = registerItem("mesoglea", new Item(new FabricItemSettings()));
    // make the items more advanced, giving them a phantom variant
    public static final Item BANANA = registerItem("banana", new BananaItem(new Item.Settings().food(BananaItem.BANANA)));
    public static final Item ORANGE = registerItem("orange", new OrangeItem(new Item.Settings().food(OrangeItem.ORANGE)));
    public static final Item PEACH = registerItem("peach", new PeachItem(new Item.Settings().food(PeachItem.PEACH)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(VPEndMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VPEndMod.LOGGER.info("Registering Mod Items for " + VPEndMod.MOD_ID);
    }

}
