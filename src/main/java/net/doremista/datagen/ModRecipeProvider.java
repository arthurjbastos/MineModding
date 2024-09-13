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
                0.3f, 200, "adagsteelingot");
        offerBlasting(exporter, ADAGSTEELSMELTABLES, RecipeCategory.MISC, ModItems.ADAGSTEELINGOT,
                0.3f, 100, "adagsteelingot");

        offerSmelting(exporter, VERDANOVASAPSMELTABLES, RecipeCategory.MISC, ModItems.VERDANOVASAP,
                0.5f, 450, "verdanovasap");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.KIKIANMASS, RecipeCategory.DECORATIONS,
                ModBlocks.KIKIANMASSBLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ADAGSTEELINGOT, RecipeCategory.DECORATIONS,
                ModBlocks.ADAGSTEELBLOCK);

        offerSingleOutputShapelessRecipe(exporter, Items.PINK_DYE, ModBlocks.CARNATION, "pink_dye");



        // LORE'S CRAFT VIA MUSIC DISCS
        offerSingleOutputShapelessRecipe(exporter, ModItems.EVELYNLORE, ModItems.EVELYNTHEMEMUSICDISC, "evelynlore");
        offerSingleOutputShapelessRecipe(exporter, ModItems.EVELYNTHEMEMUSICDISC, ModItems.EVELYNLORE, "evelynthememusicdisc");

        offerSingleOutputShapelessRecipe(exporter, ModItems.ELEPHASTICLORE, ModItems.ELEPHASTICTHEMEMUSICDISC, "elephasticlore");
        offerSingleOutputShapelessRecipe(exporter, ModItems.ELEPHASTICTHEMEMUSICDISC, ModItems.ELEPHASTICLORE, "elephasticthememusicdisc");

        offerSingleOutputShapelessRecipe(exporter, ModItems.BATCHERSLORE, ModItems.BATCHERSTHEMEMUSICDISC, "batcherslore");
        offerSingleOutputShapelessRecipe(exporter, ModItems.BATCHERSTHEMEMUSICDISC, ModItems.BATCHERSLORE, "batchersthememusicdisc");
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
                    .offerTo(exporter);

            createFenceRecipe(ModBlocks.VERDANOVAFENCE, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter);

            createFenceGateRecipe(ModBlocks.VERDANOVAFENCEGATE, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter);

            createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERDANOVASLAB, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter);

            createTrapdoorRecipe(ModBlocks.VERDANOVATRAPDOOR, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter);

            createStairsRecipe(ModBlocks.VERDANOVASTAIRS, Ingredient.ofItems(ModBlocks.VERDANOVAPLANKS))
                    .criterion(hasItem(ModBlocks.VERDANOVAPLANKS), conditionsFromItem(ModBlocks.VERDANOVAPLANKS))
                    .offerTo(exporter);

        //

        createDoorRecipe(ModBlocks.ADAGSTEELDOOR, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        createFenceRecipe(ModBlocks.ADAGSTEELFENCE, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        createFenceGateRecipe(ModBlocks.ADAGSTEELFENCEGATE, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAGSTEELSLAB, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        createTrapdoorRecipe(ModBlocks.ADAGSTEELTRAPDOOR, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        createStairsRecipe(ModBlocks.ADAGSTEELSTAIRS, Ingredient.ofItems(ModItems.ADAGSTEELINGOT))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PERFECTTENCAKE, 1)
                .pattern("TLT")
                .pattern("OOO")
                .pattern("TCT")
                .input('O', Items.EGG)
                .input('L', Items.MILK_BUCKET)
                .input('T', Items.WHEAT)
                .input('C', Items.COCOA_BEANS)
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        //      **** VERDANOVA STUFF ****

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VERDANOVASAPBOTTLE, 1)
                .pattern("###")
                .pattern("#B#")
                .pattern("###")
                .input('#', ModItems.VERDANOVASAP)
                .input('B', Items.GLASS_BOTTLE)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(ModItems.VERDANOVASAP), conditionsFromItem(ModItems.VERDANOVASAP))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HEALERBOOK, 1)
                .pattern("PAP")
                .pattern("SBS")
                .pattern("PAP")
                .input('S', ModItems.VERDANOVASAPBOTTLE)
                .input('A', ModItems.ADAGIOREDUCER)
                .input('B', Items.BOOK)
                .input('P', Items.PAPER)
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(ModItems.VERDANOVASAPBOTTLE), conditionsFromItem(ModItems.VERDANOVASAPBOTTLE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMANDIAHELMET, 1)
                .pattern("###")
                .pattern("#B#")
                .pattern("   ")
                .input('B', ModItems.VERDANOVASAPBOTTLE)
                .input('#', ModBlocks.VERDANOVALOG)
                .criterion(hasItem(ModItems.VERDANOVASAPBOTTLE), conditionsFromItem(ModItems.VERDANOVASAPBOTTLE))
                .criterion(hasItem(ModBlocks.VERDANOVALOG), conditionsFromItem(ModBlocks.VERDANOVALOG))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMANDIABOOTS, 1)
                .pattern("B B")
                .pattern("# #")
                .pattern("# #")
                .input('B', ModItems.VERDANOVASAPBOTTLE)
                .input('#', ModBlocks.VERDANOVALOG)
                .criterion(hasItem(ModItems.VERDANOVASAPBOTTLE), conditionsFromItem(ModItems.VERDANOVASAPBOTTLE))
                .criterion(hasItem(ModBlocks.VERDANOVALOG), conditionsFromItem(ModBlocks.VERDANOVALOG))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMANDIACHESTPLATE, 1)
                .pattern("#B#")
                .pattern("###")
                .pattern("###")
                .input('B', ModItems.VERDANOVASAPBOTTLE)
                .input('#', ModBlocks.VERDANOVALOG)
                .criterion(hasItem(ModItems.VERDANOVASAPBOTTLE), conditionsFromItem(ModItems.VERDANOVASAPBOTTLE))
                .criterion(hasItem(ModBlocks.VERDANOVALOG), conditionsFromItem(ModBlocks.VERDANOVALOG))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMANDIALEGGINGS, 1)
                .pattern("###")
                .pattern("#B#")
                .pattern("# #")
                .input('B', ModItems.VERDANOVASAPBOTTLE)
                .input('#', ModBlocks.VERDANOVALOG)
                .criterion(hasItem(ModItems.VERDANOVASAPBOTTLE), conditionsFromItem(ModItems.VERDANOVASAPBOTTLE))
                .criterion(hasItem(ModBlocks.VERDANOVALOG), conditionsFromItem(ModBlocks.VERDANOVALOG))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADAGIOREDUCER, 1)
                .pattern(" O ")
                .pattern("SVS")
                .pattern(" O ")
                .input('S', ModItems.ILUMSHARD)
                .input('O', Items.GOLD_INGOT)
                .input('V', Items.GLASS_PANE)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(ModItems.ILUMSHARD), conditionsFromItem(ModItems.ILUMSHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FREQUENCYEXTRACTOR, 1)
                .pattern(" AD")
                .pattern(" RA")
                .pattern("A  ")
                .input('R', ModItems.ADAGIOREDUCER)
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(ModItems.ADAGIOREDUCER), conditionsFromItem(ModItems.ADAGIOREDUCER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.HARDAGSTEELFORGE, 1)
                .pattern("CCC")
                .pattern("AMA")
                .pattern("CGC")
                .input('M', ModItems.HARDAGSTEELMOLD)
                .input('A', ModBlocks.ADAGSTEELBLOCK)
                .input('G', Blocks.MAGMA_BLOCK)
                .input('C', Blocks.DEEPSLATE_TILES)
                .criterion(hasItem(ModItems.HARDAGSTEELMOLD), conditionsFromItem(ModItems.HARDAGSTEELMOLD))
                .offerTo(exporter);


        // ferramentas usando ADAGSTEELINGOT

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELSWORD) // Espada
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELPICKAXE) // Picareta
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELSHOVEL) // Pá
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELAXE) // Machado
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        // Adicionar receita para machado virado para o outro lado
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELAXE) // Machado virado
                .pattern("AA")
                .pattern("BA")
                .pattern("B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELAXE) + "_flipped"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELHOE) // Enxada
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAGSTEELHOE) // Enxada flipada
                .pattern("AA")
                .pattern("B ")
                .pattern("B ")
                .input('A', ModItems.ADAGSTEELINGOT)
                .input('B', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAGSTEELHOE) + "_flipped"));

        //  armaduras ADAGSTEELINGOT
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELHELMET) // Capacete
                .pattern("AAA")
                .pattern("A A")
                .input('A', ModItems.ADAGSTEELINGOT)
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELCHESTPLATE) // Peitoral
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ModItems.ADAGSTEELINGOT)
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELLEGGINGS) // Calças
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .input('A', ModItems.ADAGSTEELINGOT)
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAGSTEELBOOTS) // Botas
                .pattern("A A")
                .pattern("A A")
                .input('A', ModItems.ADAGSTEELINGOT)
                .criterion(hasItem(ModItems.ADAGSTEELINGOT), conditionsFromItem(ModItems.ADAGSTEELINGOT))
                .offerTo(exporter);

    }

}