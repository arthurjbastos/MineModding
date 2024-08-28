package net.doremista.world.gen;

import net.doremista.world.ModPlacedFeatures;
import net.doremista.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {

    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ALCATRAZ),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CARNATIONPLACEKEY);
    }
}
