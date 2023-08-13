package net.sixeyes.vpend.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.sixeyes.vpend.status_effect.ModStatusEffects;

public class OrangeItem extends Item {

    public static final FoodComponent ORANGE = new FoodComponent.
            Builder().hunger(8).saturationModifier(0.7f)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.IMMUNITY, 600, 0), 0.6f).build();
    public OrangeItem(Settings settings) {
        super(settings);
    }
}
