package net.doremista.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent PERFECTTENCAKE = new FoodComponent.Builder().hunger(9).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 400), 0.25f).build();

    public static final FoodComponent VERDANOVASAP = new FoodComponent.Builder().hunger(1).saturationModifier(0.01f)
            .snack()
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 0.45f).build();

    public static final FoodComponent VERDANOVASAPBOTTLE = new FoodComponent.Builder().hunger(1).saturationModifier(0.7f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500), 1.00f).build();

}
