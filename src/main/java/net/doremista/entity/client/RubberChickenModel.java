// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.doremista.entity.client;

import net.doremista.entity.animation.ModAnimations;
import net.doremista.entity.custom.RubberChickenEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class RubberChickenModel<T extends RubberChickenEntity> extends SinglePartEntityModel<T> {
    private final ModelPart rubberChicken;
    private final ModelPart head;

    public RubberChickenModel(ModelPart root) {
        this.rubberChicken = root.getChild("rubberChicken");
        this.head = rubberChicken.getChild("body").getChild("torso").getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData rubberChicken = modelPartData.addChild("rubberChicken", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, -2.5F));

        ModelPartData body = rubberChicken.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -7.9507F, 1.5F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = torso.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -0.5493F, -6.5F, 6.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData wings = torso.addChild("wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftWing = wings.addChild("leftWing", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData wingLeft_r1 = leftWing.addChild("wingLeft_r1", ModelPartBuilder.create().uv(14, 13).cuboid(2.75F, 0.4507F, -5.5F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData rightWing = wings.addChild("rightWing", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData wingRight_r1 = rightWing.addChild("wingRight_r1", ModelPartBuilder.create().uv(22, 7).cuboid(-3.75F, 0.4507F, -5.5F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(11, 22).cuboid(-2.0F, -3.5493F, 0.5F, 4.0F, 1.0F, 3.0F, new Dilation(-0.001F))
                .uv(22, 23).cuboid(-1.001F, -8.9507F, 0.2502F, 2.0F, 3.0F, 3.0F, new Dilation(-0.001F))
                .uv(0, 13).cuboid(-2.0F, -6.5493F, -0.25F, 4.0F, 8.0F, 3.0F, new Dilation(-0.002F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(0, 24).cuboid(-1.0F, -7.1871F, 2.3391F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -2.5307F, 0.0F, -3.1416F));

        ModelPartData bone = head.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r4 = bone.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, -3.5493F, 0.5F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(7, 26).cuboid(-2.0F, -3.5493F, 0.5F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData bone2 = head.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r5 = bone2.addChild("cube_r5", ModelPartBuilder.create().uv(20, 4).cuboid(-1.0F, 1.4507F, 1.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(20, 0).cuboid(-2.0F, 0.4507F, 0.5F, 4.0F, 1.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData leg2 = body.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r6 = leg2.addChild("cube_r6", ModelPartBuilder.create().uv(28, 4).cuboid(-3.0F, 6.9507F, -1.5F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(15, 27).cuboid(-3.0F, 4.4507F, -2.5F, 2.0F, 3.0F, 2.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 0.0F, 1.5F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData leg1 = body.addChild("leg1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r7 = leg1.addChild("cube_r7", ModelPartBuilder.create().uv(11, 13).cuboid(1.0F, 6.9507F, -1.5F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(28, 16).cuboid(1.0F, 4.4507F, -2.5F, 2.0F, 3.0F, 2.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 0.0F, 1.5F, -3.1416F, 0.0F, 3.1416F));
        return TexturedModelData.of(modelData, 48, 48);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        rubberChicken.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return rubberChicken;
    }

    @Override
    public void setAngles(RubberChickenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ModAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACK, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
}