package net.doremista.block;

import net.doremista.Doremitales;
import net.doremista.block.custom.SpaceBoxBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SPACEBOX = registerBlock("spacebox",
            new SpaceBoxBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .strength(3.5f, 6.5f) // Ajuste a resistência e dureza para ser facilmente quebrado

            ));

    public static final Block KIKIANMASSBLOCK = registerBlock("kikianmassblock",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK)
                    .strength(4.5f, 6.0f) // Ajuste a resistência e dureza para que o bloco seja fácil de quebrar

            ));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Doremitales.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Doremitales.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Doremitales.LOGGER.info("Registering ModBlocks for DoremiTales");
    }
}
