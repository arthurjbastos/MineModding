//package net.doremista.client.renderer;
//
//import net.doremista.item.ModItems;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.render.OverlayTexture;
//import net.minecraft.client.render.VertexConsumerProvider;
//import net.minecraft.client.render.entity.EntityRenderer;
//import net.minecraft.client.render.entity.EntityRendererFactory;
//import net.minecraft.client.render.model.BakedModel;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.math.RotationAxis;
//import net.minecraft.item.ItemStack;
//
//public class RatchattsProjectileRenderer extends EntityRenderer<RatchattsProjectileEntity> {
//
//    public RatchattsProjectileRenderer(EntityRendererFactory.Context context) {
//        super(context);
//    }
//
//    @Override
//    public void render(RatchattsProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
//        matrices.push();
//
//        // Ajusta a rotação do projétil conforme necessário
//        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.getYaw()));
//        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.getPitch()));
//
//        // Renderiza o modelo 3D customizado
//        ItemStack itemStack = new ItemStack(ModItems.RATCHATTS);
//        BakedModel model = MinecraftClient.getInstance().getItemRenderer().getModel(itemStack, entity.getWorld(), null, entity.getId());
//
//
//        matrices.pop();
//        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
//    }
//
//    @Override
//    public Identifier getTexture(RatchattsProjectileEntity entity) {
//        return new Identifier("doremitales", "textures/item/ratchatts_3d.png");
//    }
//}
