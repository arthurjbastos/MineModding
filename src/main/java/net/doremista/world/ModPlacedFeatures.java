package net.doremista.world;

import net.doremista.Doremitales;
import net.doremista.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ADAGSTEELOREPLACEKEY = registerKey("adagsteeloreplaced");
    public static final RegistryKey<PlacedFeature> VERDANOVAKEY = registerKey("verdanovaplaced");
    public static final RegistryKey<PlacedFeature> CARNATIONPLACEKEY = registerKey("carnationplaced");

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        // blame kaupenjoe for the var name I just stole his tutorial
        register(context, ADAGSTEELOREPLACEKEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ADAGSTEELOREKEY),
                ModOrePlacement.modifiersWithCount(11, // vein p/ chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(80))));

        register(context, CARNATIONPLACEKEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CARNATIONKEY),
                List.of(HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE)));

        register(context, VERDANOVAKEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VERDANOVAKEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(7, 0.1f, 1),
                        ModBlocks.VERDANOVASAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Doremitales.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
