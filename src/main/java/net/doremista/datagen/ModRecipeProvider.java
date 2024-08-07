package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.KIKIANMASS, RecipeCategory.DECORATIONS,
                ModBlocks.KIKIANMASSBLOCK); //metodo pronto p compactar e reverter 9 itens em bloco

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HEALERBOOK, 1)
                .pattern("###")
                .pattern("#B#")
                .pattern("###")
                .input('#', ModItems.KIKIANMASS)
                .input('B', Items.BOOK)
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .criterion(hasItem(ModItems.KIKIANMASS), conditionsFromItem(ModItems.KIKIANMASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HEALERBOOK)));


    }
}
