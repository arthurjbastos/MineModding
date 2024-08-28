package net.doremista.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HealerBookItem extends Item {
    public HealerBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            int useDuration = this.getMaxUseTime(stack) - remainingUseTicks;
            if (useDuration >= 20) {

                // Curar o jogador
                if (user instanceof PlayerEntity player) {

                    (user).heal(4.5F); // Cura 2 corações e meio
                    player.getItemCooldownManager().set(this, 90);

                    //Toca som de cure
                    world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1.0F, 1.0F);
                }

                // Causar dano ao item (reduzir a durabilidade)
                stack.damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));

                // Gerar partículas
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticles(ParticleTypes.HEART, user.getX(), user.getY() + 1, user.getZ(), 6, 0.5, 0.5, 0.5, 0.1);
                }
            }

        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000; // Define o tempo máximo de uso (similar ao arco)
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW; // Define a ação de uso como a do arco
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.doremitales.healerbook.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.space.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.healerbook.tooltip.description"));
        } else {
            tooltip.add(Text.translatable("tooltip.doremitales.healerbook.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
