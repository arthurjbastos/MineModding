package net.doremista.block;

import net.doremista.Doremitales;
import net.doremista.block.custom.BenchBlock;
import net.doremista.block.custom.SpaceBoxBlock;
import net.doremista.block.custom.SurrealCrystalBlock;
import net.doremista.world.tree.VerdanovaSaplingGenerator;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
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

    public static final Block SURREALCRYSTAL = registerBlock("surrealcrystal",
            new SurrealCrystalBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).nonOpaque()// Ajuste a resistência e dureza para que o bloco seja fácil de quebrar

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

    //  VERDANOVA WOOD

    public static final Block VERDANOVALOG = registerBlock("verdanovalog",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block VERDANOVAWOOD = registerBlock("verdanovawood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPEDVERDANOVALOG = registerBlock("strippedverdanovalog",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPEDVERDANOVAWOOD = registerBlock("strippedverdanovawood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block VERDANOVASAPLING = registerBlock("verdanovasapling",
            new SaplingBlock(new VerdanovaSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block VERDANOVAPLANKS = registerBlock("verdanovaplanks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block VERDANOVALEAVES = registerBlock("verdanovaleaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

    //      FIM DA VERDOVA WOOD

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
