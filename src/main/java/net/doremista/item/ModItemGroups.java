package net.doremista.item;

import net.doremista.Doremitales;
import net.doremista.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MISC_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Doremitales.MOD_ID, "kikianmass"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.miscgroup"))
                    .icon(() -> new ItemStack(ModItems.KIKIANMASS)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KIKIANMASS);
                        entries.add(ModItems.ILUM);
                        entries.add(ModItems.ILUMSHARD);
                        entries.add(ModItems.ADAGIOREDUCER);
                        entries.add(ModItems.VERDANOVAWOODSPLINTERS);
                        entries.add(ModItems.VERDANOVASAP);
                        entries.add(ModItems.VERDANOVASAPBOTTLE);
                        entries.add(ModItems.ADAGSTEELINGOT);
                        entries.add(ModItems.RAWADAGSTEEL);
                        entries.add(ModItems.HARDAGSTEELMOLD);
                        entries.add(ModItems.ADAGSTEELIMBUED);
                        entries.add(ModItems.MELTEDADAGSTEELALLOY);
                        entries.add(ModItems.HARDAGSTEELALLOY);

                        entries.add(ModItems.PERFECTTENCAKE);
                        entries.add(ModItems.RUBBEREGG);
                        entries.add(ModItems.MELTEDRUBBEREGG);

                        // TOOLS
                        entries.add(ModItems.HEALERBOOK);
                        entries.add(ModItems.RUBBERTRUMPET);

                        entries.add(ModItems.RATCHATTS);
                        entries.add(ModItems.AEONFLUTE);
                        entries.add(ModItems.FREQUENCYEXTRACTOR);


                        //ADAGSTEEL TOOLS
                        entries.add(ModItems.ADAGSTEELSWORD);
                        entries.add(ModItems.ADAGSTEELPICKAXE);
                        entries.add(ModItems.ADAGSTEELAXE);
                        entries.add(ModItems.ADAGSTEELSHOVEL);
                        entries.add(ModItems.ADAGSTEELHOE);
                        entries.add(ModItems.ADAGSTEELHELMET);
                        entries.add(ModItems.ADAGSTEELCHESTPLATE);
                        entries.add(ModItems.ADAGSTEELLEGGINGS);
                        entries.add(ModItems.ADAGSTEELBOOTS);

                        //  HARDAGSTEEL

                        entries.add(ModItems.HARDAGSTEELSWORD);
                        entries.add(ModItems.HARDAGSTEELPICKAXE);
                        entries.add(ModItems.HARDAGSTEELAXE);
                        entries.add(ModItems.HARDAGSTEELSHOVEL);
                        entries.add(ModItems.HARDAGSTEELHOE);

                        entries.add(ModItems.HARDAGSTEELHELMET);
                        entries.add(ModItems.HARDAGSTEELCHESTPLATE);
                        entries.add(ModItems.HARDAGSTEELLEGGINGS);
                        entries.add(ModItems.HARDAGSTEELBOOTS);

                        //  LUMANDIAS

                        entries.add(ModItems.LUMANDIAHELMET);
                        entries.add(ModItems.LUMANDIACHESTPLATE);
                        entries.add(ModItems.LUMANDIALEGGINGS);
                        entries.add(ModItems.LUMANDIABOOTS);


                        // lores at the end
                        entries.add(ModItems.HARDAGSTEELGUIDE1);
                        entries.add(ModItems.HARDAGSTEELGUIDE2);
                        entries.add(ModItems.CODEXPAGE1);
                        entries.add(ModItems.EVELYNLORE);
                        entries.add(ModItems.ELEPHASTICLORE);
                        entries.add(ModItems.BATCHERSLORE);

                        // music disc no final
                        entries.add(ModItems.EVELYNTHEMEMUSICDISC);
                        entries.add(ModItems.BATCHERSTHEMEMUSICDISC);
                        entries.add(ModItems.ELEPHASTICTHEMEMUSICDISC);

                        // spawn egg
                        entries.add(ModItems.RUBBERCHICKENSPAWNEGG);


            }).build());

    public static final ItemGroup BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Doremitales.MOD_ID, "kikianmassblock"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blocksgroup"))
                    .icon(() -> new ItemStack(ModBlocks.KIKIANMASSBLOCK)).entries((displayContext, entries) -> {

                        //BLOCKS
                        entries.add(ModBlocks.BENCH);
                        entries.add(ModBlocks.KIKIANMASSBLOCK);
                        entries.add(ModBlocks.ADAGSTEELORE);
                        entries.add(ModBlocks.DEEPSLATEADAGSTEELORE);
                        entries.add(ModBlocks.SPACEBOX);
                        entries.add(ModBlocks.HARDAGSTEELFORGE);
                        entries.add(ModBlocks.ADAGSTEELBLOCK);
                        entries.add(ModBlocks.ADAGSTEELSTAIRS);
                        entries.add(ModBlocks.ADAGSTEELWALL);
                        entries.add(ModBlocks.ADAGSTEELSLAB);
                        entries.add(ModBlocks.ADAGSTEELDOOR);
                        entries.add(ModBlocks.ADAGSTEELFENCE);
                        entries.add(ModBlocks.ADAGSTEELFENCEGATE);
                        entries.add(ModBlocks.ADAGSTEELTRAPDOOR);

                        //VERDANOVA SET

                        entries.add(ModBlocks.CARNATION);
                        entries.add(ModBlocks.VERDANOVASAPLING);
                        entries.add(ModBlocks.VERDANOVALOG);
                        entries.add(ModBlocks.VERDANOVAWOOD);
                        entries.add(ModBlocks.STRIPPEDVERDANOVALOG);
                        entries.add(ModBlocks.STRIPPEDVERDANOVAWOOD);
                        entries.add(ModBlocks.VERDANOVAPLANKS);
                        entries.add(ModBlocks.VERDANOVALEAVES);
                        entries.add(ModBlocks.VERDANOVASTAIRS);
                        entries.add(ModBlocks.VERDANOVASLAB);
                        entries.add(ModBlocks.VERDANOVADOOR);
                        entries.add(ModBlocks.VERDANOVAFENCE);
                        entries.add(ModBlocks.VERDANOVAFENCEGATE);
                        entries.add(ModBlocks.VERDANOVATRAPDOOR);

                    }).build());

    public static void registerItemGroups(){
        Doremitales.LOGGER.info("Registering Item Groups for DoremiTales");
    }
}