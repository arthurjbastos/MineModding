package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.util.Identifier;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KIKIANMASSBLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPACEBOX);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAGSTEELORE);
        BlockStateModelGenerator.BlockTexturePool adagsteelPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ADAGSTEELBLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATEADAGSTEELORE);


        adagsteelPool.stairs(ModBlocks.ADAGSTEELSTAIRS);
        adagsteelPool.slab(ModBlocks.ADAGSTEELSLAB);
        adagsteelPool.button(ModBlocks.ADAGSTEELBUTTON);
        adagsteelPool.pressurePlate(ModBlocks.ADAGSTEELPRESSUREPLATE);
        adagsteelPool.fence(ModBlocks.ADAGSTEELFENCE);
        adagsteelPool.fenceGate(ModBlocks.ADAGSTEELFENCEGATE);
        adagsteelPool.wall(ModBlocks.ADAGSTEELWALL);

        blockStateModelGenerator.registerDoor(ModBlocks.ADAGSTEELDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ADAGSTEELTRAPDOOR);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.KIKIANMASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAGSTEELINGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAWADAGSTEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTERA, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEALERBOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PERFECTTENCAKE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RATCHATTS, Models.GENERATED);

        // ADAGSTEEL TOOL
        itemModelGenerator.register(ModItems.ADAGSTEELHOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAGSTEELAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAGSTEELPICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAGSTEELSHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAGSTEELSWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.KIKIANMASSPICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KIKIANMASSSWORD, Models.GENERATED);


    }
}
