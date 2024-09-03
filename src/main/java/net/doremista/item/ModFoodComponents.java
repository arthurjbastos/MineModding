package net.doremista.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent PERFECTTENCAKE = new FoodComponent.Builder().hunger(14).saturationModifier(1.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 800), 0.25f).build();

    public static final FoodComponent VERDANOVASAP = new FoodComponent.Builder().hunger(1).saturationModifier(0.01f)
            .snack()
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 0.45f).build();

    public static final FoodComponent VERDANOVASAPBOTTLE = new FoodComponent.Builder().hunger(1).saturationModifier(0.4f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 700), 1.00f).build();

}
