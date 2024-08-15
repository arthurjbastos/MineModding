package net.doremista;

import net.doremista.client.renderer.RatchattsProjectileRenderer;
import net.doremista.block.ModBlocks;
import net.doremista.block.entity.ModEntities;
import net.doremista.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class DoremitalesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADAGSTEELDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADAGSTEELTRAPDOOR, RenderLayer.getCutout());
        EntityRendererRegistry.register(ModEntities.RATCHATTSPROJECTILE, RatchattsProjectileRenderer::new);
    }
}