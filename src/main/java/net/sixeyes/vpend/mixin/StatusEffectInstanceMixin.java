package net.sixeyes.vpend.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.sixeyes.vpend.access.StatusEffectInstanceAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(StatusEffectInstance.class)
public abstract class StatusEffectInstanceMixin implements StatusEffectInstanceAccess {

    @Shadow
    private int amplifier;
    @Shadow
    private StatusEffect type;
    @Shadow
    public abstract boolean isActive();
    @Unique
    private boolean paused = false;

    public void applyUpdateEffect(LivingEntity entity) {
        if (this.isActive() && !this.paused) {
            this.type.applyUpdateEffect(entity, this.amplifier);
        }
    }

    public void vpend$setPaused(boolean b) {
        this.paused = b;
    }
}
