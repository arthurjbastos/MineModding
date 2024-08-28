package net.doremista.world;

import net.doremista.Doremitales;
import net.doremista.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ADAGSTEELOREKEY = registerKey("adagsteelore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VERDANOVAKEY = registerKey("verdanova");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CARNATIONKEY = registerKey("carnation");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

        context.register(CARNATIONKEY, new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        24,  // número de tentativas
                        4,   // distância máxima no eixo XZ
                        2,   // distância máxima no eixo Y
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CARNATION))))));

        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // verifica "alvos" p serem mudados pelos blocos q a gnt escolhe, atraves da tag default STONE_ORE_REPLACEABLE
        List<OreFeatureConfig.Target> overworldAdagsteelOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.ADAGSTEELORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATEADAGSTEELORE.getDefaultState()));

        // p outras dimensoes repete a List

        register(context, ADAGSTEELOREKEY, Feature.ORE, new OreFeatureConfig(overworldAdagsteelOres, 11));

        register(context, VERDANOVAKEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.VERDANOVALOG),
                // DATA GEN P/ UPDATE
                // i = altura até onde cresce antes de inclinar
                // j = quantidade de blocos p/ inclinar (ou var de altura)
                // k = quao longe arvore se inclina
                new DarkOakTrunkPlacer(7, 2, 2),

                BlockStateProvider.of(ModBlocks.VERDANOVALEAVES),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),

                new TwoLayersFeatureSize(1,0,2)).build()); //blocos em volta p/ gerar a arvore

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Doremitales.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
