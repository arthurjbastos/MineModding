package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE) //    MINERÁVEL C PICARETA
                .add(ModBlocks.KIKIANMASSBLOCK)
                .add(ModBlocks.ADAGSTEELBLOCK)
                .add(ModBlocks.ADAGSTEELORE)
                .add(ModBlocks.DEEPSLATEADAGSTEELORE)
                .add(ModBlocks.BENCH)

                // ** ADAGSTEEL SET **
                .add(ModBlocks.ADAGSTEELFENCE)
                .add(ModBlocks.ADAGSTEELFENCEGATE)
                .add(ModBlocks.ADAGSTEELDOOR)
                .add(ModBlocks.ADAGSTEELSLAB)
                .add(ModBlocks.ADAGSTEELTRAPDOOR)
                .add(ModBlocks.ADAGSTEELSTAIRS)
                .add(ModBlocks.ADAGSTEELWALL);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL) //    PEDRA
                .add(ModBlocks.KIKIANMASSBLOCK)
                .add(ModBlocks.KIKIANMASSBLOCK);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)    //  IRON
                .add(ModBlocks.ADAGSTEELORE)
                .add(ModBlocks.DEEPSLATEADAGSTEELORE)
                .add(ModBlocks.ADAGSTEELBLOCK)

                // ** ADAGSTEEL SET **
                .add(ModBlocks.ADAGSTEELFENCE)
                .add(ModBlocks.ADAGSTEELFENCEGATE)
                .add(ModBlocks.ADAGSTEELDOOR)
                .add(ModBlocks.ADAGSTEELSLAB)
                .add(ModBlocks.ADAGSTEELTRAPDOOR)
                .add(ModBlocks.ADAGSTEELSTAIRS)
                .add(ModBlocks.ADAGSTEELWALL);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);//  DIAMANTE

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_lever_4")));
        /*
        *       NETHERITE AQUI
        *
         */

        getOrCreateTagBuilder(BlockTags.FENCES) //  Tags p identificação d categorias etc
                .add(ModBlocks.ADAGSTEELFENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ADAGSTEELFENCEGATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ADAGSTEELWALL);

    }
}
