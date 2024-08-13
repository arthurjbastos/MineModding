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
    public static final ItemGroup KIKIANMASS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Doremitales.MOD_ID, "kikianmass"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kikianmass"))
                    .icon(() -> new ItemStack(ModItems.KIKIANMASS)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KIKIANMASS);
                        entries.add(ModItems.ADAGSTEELINGOT);
                        entries.add(ModItems.RAWADAGSTEEL);
                        entries.add(ModItems.LETTERA);
                        entries.add(ModItems.PERFECTTENCAKE);

                        // TOOLS
                        entries.add(ModItems.HEALERBOOK);
                        entries.add(ModItems.KIKIANMASSPICKAXE);
                        entries.add(ModItems.KIKIANMASSSWORD);

                        entries.add(ModItems.RATCHATTS);
                        entries.add(ModItems.AEONFLUTE);


                        //ADAGSTEEL TOOLS
                        entries.add(ModItems.ADAGSTEELAXE);
                        entries.add(ModItems.ADAGSTEELHOE);
                        entries.add(ModItems.ADAGSTEELPICKAXE);
                        entries.add(ModItems.ADAGSTEELSHOVEL);
                        entries.add(ModItems.ADAGSTEELSWORD);

                        //BLOCKS
                        entries.add(ModBlocks.BENCH);
                        entries.add(ModBlocks.KIKIANMASSBLOCK);
                        entries.add(ModBlocks.ADAGSTEELORE);
                        entries.add(ModBlocks.DEEPSLATEADAGSTEELORE);
                        entries.add(ModBlocks.SPACEBOX);
                        entries.add(ModBlocks.ADAGSTEELBLOCK);
                        entries.add(ModBlocks.ADAGSTEELBUTTON);
                        entries.add(ModBlocks.ADAGSTEELDOOR);
                        entries.add(ModBlocks.ADAGSTEELFENCE);
                        entries.add(ModBlocks.ADAGSTEELFENCEGATE);
                        entries.add(ModBlocks.ADAGSTEELPRESSUREPLATE);
                        entries.add(ModBlocks.ADAGSTEELTRAPDOOR);
                        entries.add(ModBlocks.ADAGSTEELWALL);
                        entries.add(ModBlocks.ADAGSTEELSLAB);
                        entries.add(ModBlocks.ADAGSTEELSTAIRS);

            }).build());

    public static void registerItemGroups(){
        Doremitales.LOGGER.info("Registering Item Groups for DoremiTales");
    }
}