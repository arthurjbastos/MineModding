package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider  {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ADAGSTEELHELMET)
                .add(ModItems.ADAGSTEELCHESTPLATE)
                .add(ModItems.ADAGSTEELLEGGINGS)
                .add(ModItems.ADAGSTEELBOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.EVELYNTHEMEMUSICDISC)
                .add(ModItems.ELEPHASTICTHEMEMUSICDISC)
                .add(ModItems.SUSUTHEMEMUSICDISC);

        getOrCreateTagBuilder(ItemTags.PLANKS) //uso das planks como madeira comum p craft
                .add(ModBlocks.VERDANOVAPLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN) // ADICIONA TAG COMO LOGS e COMBUSTIVEL
                .add(ModBlocks.VERDANOVALOG.asItem())
                .add(ModBlocks.VERDANOVAWOOD.asItem())
                .add(ModBlocks.STRIPPEDVERDANOVALOG.asItem())
                .add(ModBlocks.STRIPPEDVERDANOVAWOOD.asItem());

    }
}
