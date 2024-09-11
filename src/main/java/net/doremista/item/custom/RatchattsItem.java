package net.doremista.item.custom;

import net.doremista.entity.custom.RatchattsProjectileEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RatchattsItem extends AxeItem {

    // TODO -------- WORK IN PROGRESS ----------
    // esse item deve arremessar um projetil customizado com o modelo do machado

    public RatchattsItem(Settings settings) {
        super(ToolMaterials.IRON, 3.5F, -2.7F, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand); // Inicia o uso do item, semelhante ao arco

        return TypedActionResult.consume(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.doremitales.ratchatts.tooltip"));
        tooltip.add(Text.translatable("tooltip.doremitales.test.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }


    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;

            // Calcula o tempo de "puxada" (quanto tempo o botão foi segurado)
            int useTime = this.getMaxUseTime(stack) - remainingUseTicks;

            if (useTime >= 7) { // 10 ticks = 0,5 segundos
                if (!world.isClient) {
                    RatchattsProjectileEntity projectileEntity = new RatchattsProjectileEntity((PlayerEntity) user, world);
                    projectileEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);

                    world.spawnEntity(projectileEntity);
                    world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F);

                    stack.damage(1, player, (p) -> p.sendToolBreakStatus(player.getActiveHand()));

                    if (!player.getAbilities().creativeMode) {
                        stack.decrement(1);
                    }
                }
            }
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 1500; // Define o tempo máximo de uso, como um arco
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR; // Retorna a animação de arco
    }

}