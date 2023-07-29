package net.sixeyes.vpend.status_effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class PhantomStatusEffect extends StatusEffect {
    protected PhantomStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x98D982);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            double flyingSpeed = 0.01;
            Vec3d lookingAt = entity.getEyePos();
            Vec3d movement = entity.getPos().add(lookingAt).multiply(flyingSpeed);
            entity.setVelocity(movement.x, movement.y, movement.z);
            entity.setSwimming(true);
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (entity instanceof PlayerEntity) {
            entity.setNoGravity(false);
            entity.setMovementSpeed(0.7f);
        }
    }
}
