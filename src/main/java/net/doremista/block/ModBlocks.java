package net.doremista.block;

import net.doremista.Doremitales;
import net.doremista.block.custom.*;
import net.doremista.item.ModItems;
import net.doremista.world.tree.VerdanovaSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {

    public static final Block SPACEBOX = registerBlock("spacebox",
            new SpaceBoxBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .strength(1.0f, 1.5f) // a resistência e dureza para ser facilmente quebrado

            ));

    public static final Block KIKIANMASSBLOCK = registerBlock("kikianmassblock",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK)
                    .strength(4.5f, 6.0f) //
            ) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
                    tooltip.add(Text.translatable("tooltip.doremitales.test.tooltip"));
                    super.appendTooltip(stack, world, tooltip, options);
                }
            }
    );

    public static final Block ADAGSTEELBLOCK = registerBlock("adagsteelblock",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                    .strength(6.5f, 7.5f) //  
            ));

    public static final Block BENCH = registerBlock("bench",
            new BenchBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()//  

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

    public static final Block HARDAGSTEELFORGE = registerBlock("hardagsteelforge",
            new HardagsteelForgeBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    //  ************* ALCATRAZ SET ************

    public static final Block CARNATION = registerBlock("carnation",
            new CarnationBlock(FabricBlockSettings.copyOf(Blocks.DANDELION).nonOpaque().noCollision().breakInstantly().luminance(state -> 6)));

    public static final Block POTTEDCARNATION = Registry.register(Registries.BLOCK,
            new Identifier(Doremitales.MOD_ID, "pottedcarnation"),
            new FlowerPotBlock(CARNATION, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION).nonOpaque()));

    //  VERDANOVA WOOD

    public static final Block VERDANOVALOG = registerBlock("verdanovalog",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)) {
                @Override
                public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
                    ItemStack stack = player.getStackInHand(hand);
                    if (stack.getItem() instanceof AxeItem) {
                        if (!world.isClient) {
                            // Muda estado do bloco p/ stripped
                            world.setBlockState(pos, ModBlocks.STRIPPEDVERDANOVALOG.getDefaultState());
                            ItemStack dropStack = new ItemStack(ModItems.VERDANOVAWOODSPLINTERS);

                            // Toca o som de descascar
                            world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);

                            // Remove durabilidade do machado
                            stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                            Block.dropStack(world, pos, dropStack);
                        }
                        return ActionResult.success(world.isClient);
                    }
                    return ActionResult.PASS;
                }
            });

    public static final Block VERDANOVAWOOD = registerBlock("verdanovawood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)) {
                @Override
                public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
                    ItemStack stack = player.getStackInHand(hand);
                    if (stack.getItem() instanceof AxeItem) {
                        if (!world.isClient) {
                            // Muda estado do bloco p/ stripped
                            world.setBlockState(pos, ModBlocks.STRIPPEDVERDANOVAWOOD.getDefaultState());

                            // Toca o som de descascar
                            world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);

                            // Remove durabilidade do machado
                            stack.damage(1, player, p -> p.sendToolBreakStatus(hand));

                            // Dropa o item desejado
                            ItemStack dropStack = new ItemStack(ModItems.VERDANOVAWOODSPLINTERS);
                            Block.dropStack(world, pos, dropStack);
                        }
                        return ActionResult.success(world.isClient);
                    }
                    return ActionResult.PASS;
                }
            });

        public static final Block STRIPPEDVERDANOVALOG = registerBlock("strippedverdanovalog",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
        public static final Block STRIPPEDVERDANOVAWOOD = registerBlock("strippedverdanovawood",
                new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

        public static final Block VERDANOVASAPLING = registerBlock("verdanovasapling",
                new SaplingBlock(new VerdanovaSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.DARK_OAK_SAPLING)));
        public static final Block VERDANOVAPLANKS = registerBlock("verdanovaplanks",
                new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
        public static final Block VERDANOVALEAVES = registerBlock("verdanovaleaves",
                new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));

        public static final Block VERDANOVASTAIRS = registerBlock("verdanovastairs",
                new StairsBlock(ModBlocks.VERDANOVAPLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
        public static final Block VERDANOVASLAB = registerBlock("verdanovaslab",
                new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
        public static final Block VERDANOVAFENCE = registerBlock("verdanovafence",
                new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
        public static final Block VERDANOVAFENCEGATE = registerBlock("verdanovafencegate",
                new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.ACACIA));
        public static final Block VERDANOVADOOR = registerBlock("verdanovadoor",
                new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque(), BlockSetType.OAK));
        public static final Block VERDANOVATRAPDOOR = registerBlock("verdanovatrapdoor",
                new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque(), BlockSetType.OAK));

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
