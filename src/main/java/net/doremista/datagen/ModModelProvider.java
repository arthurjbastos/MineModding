package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KIKIANMASSBLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPACEBOX);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.KIKIANMASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTERA, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEALERBOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PERFECTTENCAKE, Models.GENERATED);

        itemModelGenerator.register(ModItems.KIKIANMASSPICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KIKIANMASSSWORD, Models.GENERATED);


    }
}
