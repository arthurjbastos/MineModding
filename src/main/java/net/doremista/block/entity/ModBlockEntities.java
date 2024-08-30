package net.doremista.block.entity;

import net.doremista.Doremitales;
import net.doremista.block.ModBlocks;
import net.doremista.block.entity.custom.HardagsteelForgeBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.doremista.block.entity.custom.SpaceBoxBlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<SpaceBoxBlockEntity> SPACE_BOX_BLOCK_ENTITY =
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(Doremitales.MOD_ID, "spaceboxblockentity"),
                    BlockEntityType.Builder.create(SpaceBoxBlockEntity::new, ModBlocks.SPACEBOX).build(null));

    public static final BlockEntityType<HardagsteelForgeBlockEntity> HARDAGSTEEL_FORGE_BLOCK_ENTITY =
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(Doremitales.MOD_ID, "hardagsteelforgeblockentity"),
                    FabricBlockEntityTypeBuilder.create(HardagsteelForgeBlockEntity::new,
                            ModBlocks.HARDAGSTEELFORGE).build());


    public static void registerBlockEntities() {
        Doremitales.LOGGER.info("Registering Block Entities for DoremiTales");
    }
}
