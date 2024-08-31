package net.doremista.entity;

import net.doremista.Doremitales;
import net.doremista.entity.custom.RubberChickenEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<RubberChickenEntity> RUBBERCHICKEN = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Doremitales.MOD_ID, "rubberchicken"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RubberChickenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 0.7f))  // Adjusted dimensions for a chicken-like entity
                    .build()
    );

    public static void registerModEntities() {
        Doremitales.LOGGER.info("Registering Entities for " + Doremitales.MOD_ID);
    }
}
