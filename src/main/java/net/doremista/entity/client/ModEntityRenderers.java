package net.doremista.entity.client;

import net.doremista.entity.ModEntities;
import net.doremista.entity.custom.RatchattsProjectileEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;

public class ModEntityRenderers {
    public static void register() {
        // Registra o renderizador do projétil com um modelo 3D customizado
        EntityRendererRegistry.register(ModEntities.RATCHATTS_PROJECTILE, (context) ->
                new FlyingItemEntityRenderer<RatchattsProjectileEntity>(context, 1.0f, true));
    }
}
