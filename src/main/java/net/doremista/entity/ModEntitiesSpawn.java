package net.doremista.entity;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

public class ModEntitiesSpawn {

    public static void addEntitySpawn() {
        // Defina os biomas onde o RubberChicken deve spawnar naturalmente
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST,
                        BiomeKeys.BIRCH_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.TAIGA, BiomeKeys.JUNGLE, BiomeKeys.SWAMP),
                SpawnGroup.CREATURE,
                ModEntities.RUBBERCHICKEN, // Substitua pelo EntityType da sua entidade
                100,  // Peso (quanto maior, maior a chance de spawn)
                2,    // Mínimo de entidades por grupo
                5     // Máximo de entidades por grupo
        );
    }
}
