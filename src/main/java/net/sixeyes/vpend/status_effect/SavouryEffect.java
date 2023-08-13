package net.sixeyes.vpend.status_effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SavouryEffect extends StatusEffect {
    protected SavouryEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x98D982);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // slows down saturation decay
        if (entity.isPlayer()) {
            ///
        }
    }
}
