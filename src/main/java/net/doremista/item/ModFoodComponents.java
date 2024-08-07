package net.doremista.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent PERFECTTENCAKE = new FoodComponent.Builder().hunger(9).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 400), 0.25f).build();
}
