package net.doremista.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.doremista.block.ModBlocks;
import net.doremista.recipe.HardagsteelForgeRecipe;
import net.doremista.screen.HardagsteelForgeScreen;

import java.awt.*;

public class DoremitalesREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new HardagsteelForgeCategory());

        registry.addWorkstations(HardagsteelForgeCategory.HARDAGSTEEL_FORGE, EntryStacks.of(ModBlocks.HARDAGSTEELFORGE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(HardagsteelForgeRecipe.class, HardagsteelForgeRecipe.Type.INSTANCE,
                HardagsteelForgeDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), HardagsteelForgeScreen.class,
                HardagsteelForgeCategory.HARDAGSTEEL_FORGE);
    }
}
