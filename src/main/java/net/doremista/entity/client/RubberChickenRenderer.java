package net.doremista.entity.client;

import net.doremista.entity.custom.RubberChickenEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RubberChickenRenderer extends MobEntityRenderer<RubberChickenEntity, RubberChickenModel<RubberChickenEntity>> {

    private static final Identifier TEXTURE = new Identifier("doremitales", "textures/entity/rubberchicken.png");

    public RubberChickenRenderer(EntityRendererFactory.Context context) {
        super(context, new RubberChickenModel<>(context.getPart(ModModelLayers.RUBBERCHICKEN)), 0.2f); // SHADOW
    }

    @Override
    public Identifier getTexture(RubberChickenEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(RubberChickenEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);  // Call super.render to ensure the model is rendered
    }
}
