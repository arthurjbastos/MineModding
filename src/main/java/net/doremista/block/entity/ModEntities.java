package net.doremista.block.entity;

import net.doremista.Doremitales;
import net.doremista.block.entity.custom.RatchattsProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<RatchattsProjectileEntity> RATCHATTSPROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Doremitales.MOD_ID, "ratchattsprojectile"), FabricEntityTypeBuilder.<RatchattsProjectileEntity>create(SpawnGroup.MISC, RatchattsProjectileEntity::new )
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
}
