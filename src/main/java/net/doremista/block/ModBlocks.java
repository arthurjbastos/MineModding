package net.doremista.block;

import net.doremista.Doremitales;
import net.doremista.block.custom.BenchBlock;
import net.doremista.block.custom.SpaceBoxBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block SPACEBOX = registerBlock("spacebox",
            new SpaceBoxBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .strength(1.0f, 1.5f) // Ajuste a resistência e dureza para ser facilmente quebrado

            ));

    public static final Block KIKIANMASSBLOCK = registerBlock("kikianmassblock",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK)
                    .strength(4.5f, 6.0f) // Ajuste a resistência e dureza para que o bloco seja fácil de quebrar

            ));

    public static final Block ADAGSTEELBLOCK = registerBlock("adagsteelblock",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .strength(6.5f, 7.5f) // Ajuste a resistência e dureza para que o bloco seja fácil de quebrar

            ));

    public static final Block BENCH = registerBlock("bench",
            new BenchBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()// Ajuste a resistência e dureza para que o bloco seja fácil de quebrar

            ));

    public static final Block ADAGSTEELORE = registerBlock("adagsteelore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)

            ));

    public static final Block DEEPSLATEADAGSTEELORE = registerBlock("deepslateadagsteelore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2, 5)

            ));

    //     ********  ADAGSTEEL SET **********

    public static final Block ADAGSTEELSTAIRS = registerBlock("adagsteelstairs",
            new StairsBlock(ModBlocks.ADAGSTEELBLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ADAGSTEELSLAB = registerBlock("adagsteelslab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ADAGSTEELBUTTON = registerBlock("adagsteelbutton",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON, 10, false));
    public static final Block ADAGSTEELPRESSUREPLATE = registerBlock("adagsteelpressureplate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS,
                    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block ADAGSTEELFENCE = registerBlock("adagsteelfence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ADAGSTEELFENCEGATE = registerBlock("adagsteelfencegate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA));
    public static final Block ADAGSTEELWALL = registerBlock("adagsteelwall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ADAGSTEELDOOR = registerBlock("adagsteeldoor",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));
    public static final Block ADAGSTEELTRAPDOOR = registerBlock("adagsteeltrapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));



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
