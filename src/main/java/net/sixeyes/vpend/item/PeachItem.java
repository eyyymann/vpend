package net.sixeyes.vpend.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.sixeyes.vpend.status_effect.ModStatusEffects;

public class PeachItem extends Item {

    public static final FoodComponent PEACH = new FoodComponent.
            Builder().hunger(5).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.SAVOURY, 600, 0), 0.5f).build();
    public PeachItem(Settings settings) {
        super(settings);
    }
}
