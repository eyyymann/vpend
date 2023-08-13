package net.sixeyes.vpend.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class BananaItem extends Item {

    public static final FoodComponent BANANA = new FoodComponent.
            Builder().hunger(5).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0), 0.5f).build();

    public BananaItem(Settings settings) {
        super(settings);
    }
}
