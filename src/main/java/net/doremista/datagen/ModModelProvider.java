package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KIKIANMASSBLOCK);
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

        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPACEBOX);
        // SPACEBOX GERADO MANUALMENTE
        // BENCH GERADO MANUALMENTE
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.CODEXPAGE1, Models.GENERATED);
        itemModelGenerator.register(ModItems.ILUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.KIKIANMASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAGSTEELINGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAWADAGSTEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTERA, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEALERBOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PERFECTTENCAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EVELYNTHEMEMUSICDISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.RATCHATTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.AEONFLUTE, Models.GENERATED);

        // ADAGSTEEL TOOL
        itemModelGenerator.register(ModItems.ADAGSTEELHOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAGSTEELAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAGSTEELPICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAGSTEELSHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAGSTEELSWORD, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAGSTEELHELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAGSTEELCHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAGSTEELLEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAGSTEELBOOTS));

        itemModelGenerator.register(ModItems.KIKIANMASSPICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KIKIANMASSSWORD, Models.HANDHELD);

        //ITEM BENCH GERADO MANUALMENTE
    }
}
