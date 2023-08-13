package net.sixeyes.vpend.status_effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.sixeyes.vpend.access.StatusEffectInstanceAccess;

import java.util.Collection;
import java.util.List;

public class ImmunityEffect extends StatusEffect {

    protected ImmunityEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x98D982);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity.isPlayer()) {
            List<StatusEffectInstance> statusEffectInstances = entity.getStatusEffects().stream().toList();
            for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
                if (statusEffectInstance.getEffectType().getCategory().equals(StatusEffectCategory.HARMFUL)) {
                    ((StatusEffectInstanceAccess)statusEffectInstance).setPaused(true);
                }
            }
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isPlayer()) {
            List<StatusEffectInstance> statusEffectInstances = entity.getStatusEffects().stream().toList();
            for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
                if (statusEffectInstance.getEffectType().getCategory().equals(StatusEffectCategory.HARMFUL)) {
                    ((StatusEffectInstanceAccess)statusEffectInstance).setPaused(true);
                }
            }
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity.isPlayer()) {
            Collection<StatusEffectInstance> statusEffectInstances = entity.getStatusEffects();
            for (StatusEffectInstance statusEffectInstance : statusEffectInstances) {
                if (statusEffectInstance.getEffectType().getCategory().equals(StatusEffectCategory.HARMFUL)) {
                    ((StatusEffectInstanceAccess)statusEffectInstance).setPaused(false);
                }
            }
        }
    }
}
