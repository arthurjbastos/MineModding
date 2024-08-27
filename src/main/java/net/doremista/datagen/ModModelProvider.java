package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KIKIANMASSBLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAGSTEELORE);
        BlockStateModelGenerator.BlockTexturePool adagsteelPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ADAGSTEELBLOCK);
        BlockStateModelGenerator.BlockTexturePool verdanovaPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VERDANOVAPLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATEADAGSTEELORE);

        adagsteelPool.stairs(ModBlocks.ADAGSTEELSTAIRS);
        adagsteelPool.slab(ModBlocks.ADAGSTEELSLAB);
        adagsteelPool.fence(ModBlocks.ADAGSTEELFENCE);
        adagsteelPool.fenceGate(ModBlocks.ADAGSTEELFENCEGATE);
        adagsteelPool.wall(ModBlocks.ADAGSTEELWALL);
        blockStateModelGenerator.registerDoor(ModBlocks.ADAGSTEELDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ADAGSTEELTRAPDOOR);

        // verdanova set

        verdanovaPool.stairs(ModBlocks.VERDANOVASTAIRS);
        verdanovaPool.slab(ModBlocks.VERDANOVASLAB);
        verdanovaPool.fence(ModBlocks.VERDANOVAFENCE);
        verdanovaPool.fenceGate(ModBlocks.VERDANOVAFENCEGATE);
        blockStateModelGenerator.registerDoor(ModBlocks.VERDANOVADOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.VERDANOVATRAPDOOR);

        blockStateModelGenerator.registerLog(ModBlocks.VERDANOVALOG).log(ModBlocks.VERDANOVALOG).wood(ModBlocks.VERDANOVAWOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPEDVERDANOVALOG).log(ModBlocks.STRIPPEDVERDANOVALOG).wood(ModBlocks.STRIPPEDVERDANOVAWOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERDANOVALEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.VERDANOVASAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        // SPACEBOX GERADO MANUALMENTE
        // BENCH GERADO MANUALMENTE
        // crystal manual tb
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.CODEXPAGE1, Models.GENERATED);
        itemModelGenerator.register(ModItems.EVELYNLORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELEPHASTICLORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ILUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ILUMSHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAGIOREDUCER, Models.GENERATED);
        itemModelGenerator.register(ModItems.KIKIANMASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAGSTEELINGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAWADAGSTEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTERA, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEALERBOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PERFECTTENCAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EVELYNTHEMEMUSICDISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSUTHEMEMUSICDISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELEPHASTICTHEMEMUSICDISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.RATCHATTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.AEONFLUTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FREQUENCYEXTRACTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDANOVAWOODSPLINTERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDANOVASAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDANOVASAPBOTTLE, Models.GENERATED);

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

        // egg

        itemModelGenerator.register(ModItems.RUBBERCHICKENSPAWNEGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

    }
}
