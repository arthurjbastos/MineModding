package net.doremista;

import net.doremista.block.ModBlocks;
import net.doremista.entity.ModEntities;
import net.doremista.entity.client.ModEntityRenderers;
import net.doremista.entity.client.ModModelLayers;
import net.doremista.entity.client.RubberChickenModel;
import net.doremista.entity.client.RubberChickenRenderer;
import net.doremista.entity.custom.RatchattsProjectileEntity;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.doremista.screen.HardagsteelForgeScreen;
import net.doremista.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.Vec3d;

import java.util.UUID;

import static net.doremista.block.ModBlocks.VERDANOVALEAVES;


public class DoremitalesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADAGSTEELDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADAGSTEELTRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANOVADOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANOVATRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VERDANOVALEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANOVASAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARNATION, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTEDCARNATION, RenderLayer.getCutout());

        // Registro do ColorProvider para folhas com base no bioma
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return -1; // Sem cor se o mundo ou a posição forem nulos
            }
            return BiomeColors.getFoliageColor(world, pos); // Cor dinâmica baseada no bioma
        }, VERDANOVALEAVES);

        // Registro do ColorProvider para o item do bloco
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return 0x547A07; //  cor padrão
        }, ModBlocks.VERDANOVALEAVES.asItem());


        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RUBBERCHICKEN, RubberChickenModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RUBBERCHICKEN, RubberChickenRenderer::new);

        EntityRendererRegistry.register(ModEntities.RATCHATTS_PROJECTILE, FlyingItemEntityRenderer::new);
        ModEntityRenderers.register();

        HandledScreens.register(ModScreenHandlers.HARDAGSTEEL_FORGE_SCREEN_HANDLER, HardagsteelForgeScreen::new);

    }
}