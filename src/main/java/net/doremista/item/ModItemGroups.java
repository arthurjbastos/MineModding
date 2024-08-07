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
                        entries.add(ModItems.LETTERA);
                        entries.add(ModItems.HEALERBOOK);
                        entries.add(ModItems.PERFECTTENCAKE);
                        entries.add(ModItems.KIKIANMASSPICKAXE);
                        entries.add(ModItems.KIKIANMASSSWORD);

                        entries.add(ModBlocks.KIKIANMASSBLOCK);
                        entries.add(ModBlocks.SPACEBOX);

            }).build());

    public static void registerItemGroups(){
        Doremitales.LOGGER.info("Registering Item Groups for DoremiTales");
    }
}