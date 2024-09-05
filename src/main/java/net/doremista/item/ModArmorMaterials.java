package net.doremista.item;

import net.doremista.Doremitales;
import net.doremista.block.ModBlocks;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    // EXEMPLOS ACESSÍVEIS EM ArmorMaterials.clas
    ADAGSTEEL("adagsteel", 20, new int[]{ 2, 6, 5, 2}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.02f, () -> Ingredient.ofItems(ModItems.ADAGSTEELINGOT)),

    HARDAGSTEEL("hardagsteel", 39, new int[]{3, 8, 6, 3}, 18,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 2.2f, 0.04f, () -> Ingredient.ofItems(ModItems.HARDAGSTEELALLOY)),

    LUMANDIA("lumandia", 10, new int[]{2, 3, 4, 2}, 18,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.00f, () -> Ingredient.ofItems(ModBlocks.VERDANOVALOG));


    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13}; //HELMET, CHEST, LEG, BOOTS

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Doremitales.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
