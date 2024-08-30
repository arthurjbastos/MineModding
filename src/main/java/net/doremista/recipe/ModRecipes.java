package net.doremista.recipe;

import net.doremista.Doremitales;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Doremitales.MOD_ID, "hardagsteelforge"), HardagsteelForgeRecipe.Type.INSTANCE);
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Doremitales.MOD_ID, "hardagsteelforge"), HardagsteelForgeRecipe.Serializer.INSTANCE);

        Doremitales.LOGGER.info("Registering Mod Recipes for " + Doremitales.MOD_ID);

    }

}
