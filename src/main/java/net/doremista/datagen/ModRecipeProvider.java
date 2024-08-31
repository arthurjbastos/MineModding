package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> ADAGSTEELSMELTABLES = List.of(ModItems.RAWADAGSTEEL,
            ModBlocks.ADAGSTEELORE, ModBlocks.DEEPSLATEADAGSTEELORE);


    private static final List<ItemConvertible> VERDANOVASAPSMELTABLES = List.of(ModItems.VERDANOVAWOODSPLINTERS);


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        // Recipes existentes
        offerSmelting(exporter, ADAGSTEELSMELTABLES, RecipeCategory.MISC, ModItems.ADAGSTEELINGOT,
                0.5f, 200, "adagsteelingot");
        offerBlasting(exporter, ADAGSTEELSMELTABLES, RecipeCategory.MISC, ModItems.ADAGSTEELINGOT,
                0.5f, 100, "adagsteelingot");

        offerSmelting(exporter, VERDANOVASAPSMELTABLES, RecipeCategory.MISC, ModItems.VERDANOVASAP,
                0.5f, 450, "verdanovasap");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.KIKIANMASS, RecipeCategory.DECORATIONS,
                ModBlocks.KIKIANMASSBLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ADAGSTEELINGOT, RecipeCategory.DECORATIONS,
                ModBlocks.ADAGSTEELBLOCK);


        // LORE'S CRAFT VIA MUSIC DISCS
        offerSingleOutputShapelessRecipe(exporter, ModItems.EVELYNLORE, ModItems.EVELYNTHEMEMUSICDISC, "evelynlore");
        offerSingleOutputShapelessRecipe(exporter, ModItems.EVELYNTHEMEMUSICDISC, ModItems.EVELYNLORE, "evelynthememusicdisc");

        offerSingleOutputShapelessRecipe(exporter, ModItems.ELEPHASTICLORE, ModItems.ELEPHASTICTHEMEMUSICDISC, "elephasticlore");
        offerSingleOutputShapelessRecipe(exporter, ModItems.ELEPHASTICTHEMEMUSICDISC, ModItems.ELEPHASTICLORE, "elephasticthememusicdisc");
        //

        // CRAFT DE PLANKS/LOG
            offerPlanksRecipe2(exporter, ModBlocks.VERDANOVAPLANKS, ItemTags.LOGS, 4);
            offerShapelessRecipe(exporter, ModBlocks.VERDANOVAPLANKS, ModBlocks.STRIPPEDVERDANOVALOG, RecipeCategory.BUILDING_BLOCKS.getName(), 4);
            offerShapelessRecipe(exporter, ModBlocks.VERDANOVAPLANKS, ModBlocks.STRIPPEDVERDANOVAWOOD, RecipeCategory.BUILDING_BLOCKS.getName(), 4);
            offerShapelessRecipe(exporter, ModBlocks.VERDANOVAPLANKS, ModBlocks.VERDANOVAWOOD, RecipeCategory.BUILDING_BLOCKS.getName(), 4);
        //

        // VERDANOVA SET

            createDoorRecipe(ModBlocks.VERDANOVADOOR, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.VERDANOVADOOR)));

            createFenceRecipe(ModBlocks.VERDANOVAFENCE, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.VERDANOVAFENCE)));

            createFenceGateRecipe(ModBlocks.VERDANOVAFENCEGATE, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.VERDANOVAFENCEGATE)));

            createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERDANOVASLAB, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.VERDANOVASLAB)));

            createTrapdoorRecipe(ModBlocks.VERDANOVATRAPDOOR, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.VERDANOVATRAPDOOR)));

            createStairsRecipe(ModBlocks.VERDANOVASTAIRS, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.VERDANOVASTAIRS)));

        //

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

        createTrapdoorRecipe(ModBlocks.ADAGSTEELTRAPDOOR, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELTRAPDOOR)));

        createStairsRecipe(ModBlocks.ADAGSTEELSTAIRS, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADAGSTEELSTAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VERDANOVASAPBOTTLE, 1)
                .pattern("###")
                .pattern("#B#")
                .pattern("###")
                .input('#', ModItems.VERDANOVASAP)
                .input('B', Items.GLASS_BOTTLE)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(ModItems.VERDANOVASAP), conditionsFromItem(ModItems.VERDANOVASAP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VERDANOVASAPBOTTLE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HEALERBOOK, 1)
                .pattern("###")
                .pattern("#B#")
                .pattern("###")
                .input('#', ModItems.KIKIANMASS)
                .input('B', Items.BOOK)
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .criterion(hasItem(ModItems.KIKIANMASS), conditionsFromItem(ModItems.KIKIANMASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HEALERBOOK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADAGIOREDUCER, 1)
                .pattern(" O ")
                .pattern("SVS")
                .pattern(" O ")
                .input('S', ModItems.ILUMSHARD)
                .input('O', Items.GOLD_INGOT)
                .input('V', Items.GLASS_PANE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.ILUMSHARD), conditionsFromItem(ModItems.ILUMSHARD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGIOREDUCER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FREQUENCYEXTRACTOR, 1)
                .pattern(" AD")
                .pattern(" RA")
                .pattern("A  ")
                .input('R', ModItems.ADAGIOREDUCER)
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.ADAGIOREDUCER), conditionsFromItem(ModItems.ADAGIOREDUCER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FREQUENCYEXTRACTOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.HARDAGSTEELFORGE, 1)
                .pattern("CCC")
                .pattern("AMA")
                .pattern("CGC")
                .input('M', ModItems.HARDAGSTEELMOLD)
                .input('A', ModBlocks.ADAGSTEELBLOCK)
                .input('G', Blocks.MAGMA_BLOCK)
                .input('C', Blocks.DEEPSLATE_TILES)
                .criterion(hasItem(Blocks.MAGMA_BLOCK), conditionsFromItem(Blocks.MAGMA_BLOCK))
                .criterion(hasItem(ModItems.HARDAGSTEELMOLD), conditionsFromItem(ModItems.HARDAGSTEELMOLD))
                .criterion(hasItem(ModBlocks.ADAGSTEELBLOCK), conditionsFromItem(ModBlocks.ADAGSTEELBLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.HARDAGSTEELFORGE)));


        // ferramentas usando ADAGSTEELINGOT

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

        //  armaduras ADAGSTEELINGOT
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELHELMET) // Capacete
                .pattern("AAA")
                .pattern("A A")
                .input('A', ModItems.ADAGSTEELINGOT)
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELHELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELCHESTPLATE) // Peitoral
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ModItems.ADAGSTEELINGOT)
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELCHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELLEGGINGS) // Calças
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .input('A', ModItems.ADAGSTEELINGOT)
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELLEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELBOOTS) // Botas
                .pattern("A A")
                .pattern("A A")
                .input('A', ModItems.ADAGSTEELINGOT)
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELBOOTS)));

    }

}