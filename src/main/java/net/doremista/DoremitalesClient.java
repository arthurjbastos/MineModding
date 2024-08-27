package net.doremista;

import net.doremista.block.ModBlocks;
import net.doremista.entity.ModEntities;
import net.doremista.entity.client.ModModelLayers;
import net.doremista.entity.client.RubberChickenModel;
import net.doremista.entity.client.RubberChickenRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class DoremitalesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADAGSTEELDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADAGSTEELTRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANOVADOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANOVATRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANOVALEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANOVASAPLING, RenderLayer.getCutout());

        //EntityRendererRegistry.register(ModEntities.RATCHATTSPROJECTILE, RatchattsProjectileRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RUBBERCHICKEN, RubberChickenModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RUBBERCHICKEN, RubberChickenRenderer::new);
    }
}