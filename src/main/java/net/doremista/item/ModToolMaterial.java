package net.doremista.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

//WOOD durability = 59, speed = 2.0f, damage = 0.0f, enchantability = 15
//STONE durability = 131, speed = 4.0f, damage = 0.0f, enchantability = 5
//IRON durability = 250, speed = 6.0f, damage = 2.0f, enchantability = 14
//DIAMOND durability = 1561, speed = 8.0f, damage = 3.0f, enchantability = 10
//GOLD durability = 32, speed = 12.0f, damage = 0.0f, enchantability = 22
//NETHERITE durability = 2031, speed = 9.0f, damage = 4.0f, enchantability = 15


public enum ModToolMaterial implements ToolMaterial {

    ADAGSTEEL(MiningLevels.IRON, 350, 6.0f, 2.0f, 15,
            () -> Ingredient.ofItems(ModItems.ADAGSTEELINGOT)),

    HARDAGSTEEL(MiningLevels.DIAMOND, 2020, 8.3f, 3f, 15,
            () -> Ingredient.ofItems(ModItems.HARDAGSTEELALLOY));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
