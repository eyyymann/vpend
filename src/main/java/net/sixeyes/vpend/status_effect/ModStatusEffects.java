package net.sixeyes.vpend.status_effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sixeyes.vpend.VPEndMod;

public class ModStatusEffects {

    public static final StatusEffect PHANTOM = registerStatusEffect("phantom", new PhantomStatusEffect());
    public static final StatusEffect SAVOURY = registerStatusEffect("savoury", new SavouryEffect());
    public static final StatusEffect IMMUNITY = registerStatusEffect("immunity", new ImmunityEffect());

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(VPEndMod.MOD_ID, name), statusEffect);
    }

    public static void registerModStatusEffects() {

        VPEndMod.LOGGER.info("Registering Mod Mob Effects for " + VPEndMod.MOD_ID);
    }
}
