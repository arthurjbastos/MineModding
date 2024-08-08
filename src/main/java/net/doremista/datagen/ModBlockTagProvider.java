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

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.KIKIANMASSBLOCK)
                .add(ModBlocks.ADAGSTEELBLOCK)
                .add(ModBlocks.ADAGSTEELORE)

                .add(ModBlocks.DEEPSLATEADAGSTEELORE);


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.KIKIANMASSBLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ADAGSTEELORE)
                .add(ModBlocks.DEEPSLATEADAGSTEELORE)
                .add(ModBlocks.ADAGSTEELBLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_lever_4")));


        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ADAGSTEELFENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ADAGSTEELFENCEGATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ADAGSTEELWALL);

    }
}
