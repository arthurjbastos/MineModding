package net.doremista.client.renderer;

import net.doremista.block.entity.custom.RatchattsProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.Identifier;

public class RatchattsProjectileRenderer extends EntityRenderer<RatchattsProjectileEntity> {

    private static final Identifier TEXTURE = new Identifier("doremitales", "textures/entity/ratchatts_3d.png");
    private final TridentEntityModel model;

    public RatchattsProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new TridentEntityModel(context.getPart(EntityModelLayers.TRIDENT));
    }

    @Override
    public void render(RatchattsProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        // Aqui vamos apenas renderizar o modelo básico sem nenhuma rotação
        this.model.render(matrices, vertexConsumers.getBuffer(this.model.getLayer(TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(RatchattsProjectileEntity entity) {
        return TEXTURE;
    }
}
