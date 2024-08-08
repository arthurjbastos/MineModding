package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItemGroups;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> ADAGSTEELSMELTABLES = List.of(ModItems.RAWADAGSTEEL,
            ModBlocks.ADAGSTEELORE, ModBlocks.DEEPSLATEADAGSTEELORE);


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        // Recipes existentes
        offerSmelting(exporter, ADAGSTEELSMELTABLES, RecipeCategory.MISC, ModItems.ADAGSTEELINGOT,
                0.7f, 200, "adagsteelingot");
        offerBlasting(exporter, ADAGSTEELSMELTABLES, RecipeCategory.MISC, ModItems.ADAGSTEELINGOT,
                0.7f, 100, "adagsteelingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.KIKIANMASS, RecipeCategory.DECORATIONS,
                ModBlocks.KIKIANMASSBLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ADAGSTEELINGOT, RecipeCategory.DECORATIONS,
                ModBlocks.ADAGSTEELBLOCK);

        createDoorRecipe(ModBlocks.ADAGSTEELDOOR, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELDOOR)));

        createFenceRecipe(ModBlocks.ADAGSTEELFENCE, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELFENCE)));

        createFenceGateRecipe(ModBlocks.ADAGSTEELFENCEGATE, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELFENCEGATE)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAGSTEELSLAB, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELSLAB)));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAGSTEELPRESSUREPLATE, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELPRESSUREPLATE)));

        createTrapdoorRecipe(ModBlocks.ADAGSTEELTRAPDOOR, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELTRAPDOOR)));

        createStairsRecipe(ModBlocks.ADAGSTEELSTAIRS, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELSTAIRS)));

        createTransmutationRecipe(ModBlocks.ADAGSTEELBUTTON, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELBUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HEALERBOOK, 1)
                .pattern("###")
                .pattern("#B#")
                .pattern("###")
                .input('#', ModItems.KIKIANMASS)
                .input('B', Items.BOOK)
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .criterion(hasItem(ModItems.KIKIANMASS), conditionsFromItem(ModItems.KIKIANMASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HEALERBOOK)));

        // Adicionar receitas de ferramentas customizadas usando ADAGSTEELINGOT
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELSWORD) // Espada
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELSWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELPICKAXE) // Picareta
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELPICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELSHOVEL) // Pá
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELSHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELAXE) // Machado
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELAXE)));

        // Adicionar receita para machado virado para o outro lado
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELAXE) // Machado virado
                .pattern(" AA")
                .pattern(" BA")
                .pattern(" B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELAXE) + "_flipped"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELHOE) // Enxada
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELHOE)));
    }

}