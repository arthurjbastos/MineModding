package net.doremista.item.custom;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrequencyExtractorItem extends Item {
    private BlockPos currentBlockPos;

    public FrequencyExtractorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (!world.isClient) {
            currentBlockPos = pos;
            player.setCurrentHand(context.getHand());

            // Iniciar partículas contínuas
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, 1, 0.0, 0.0, 0.0, 0.1);
            }

            return ActionResult.SUCCESS;
        }

        currentBlockPos = null;
        return ActionResult.PASS;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 160;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);
        return TypedActionResult.consume(player.getStackInHand(hand));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient) {
            boolean correctBlock = currentBlockPos != null &&
                    (world.getBlockState(currentBlockPos).isOf(Blocks.JUKEBOX) || world.getBlockState(currentBlockPos).isOf(Blocks.NOTE_BLOCK) ||
                            world.getBlockState(currentBlockPos).isOf(Blocks.AMETHYST_BLOCK) || world.getBlockState(currentBlockPos).isOf(Blocks.BELL) ||
                            world.getBlockState(currentBlockPos).isOf(Blocks.SCULK_SENSOR)) || world.getBlockState(currentBlockPos).isOf(ModBlocks.CARNATION);

            if (correctBlock) {
                stack.damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));

                Vec3d dropPos = new Vec3d(currentBlockPos.getX() + 0.5, currentBlockPos.getY() + 1.5, currentBlockPos.getZ() + 0.5);

                world.spawnEntity(new ItemEntity(world, dropPos.x, dropPos.y, dropPos.z, new ItemStack(ModItems.ILUMSHARD)));

                world.playSound(null, dropPos.x, dropPos.y, dropPos.z, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 1.0F);

                // Spawn success particles
                spawnSuccessParticles((ServerWorld) world, currentBlockPos);

            } else {
                // Falha
                stack.damage(5, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));

                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_CANDLE_EXTINGUISH, SoundCategory.PLAYERS, 0.5F, 0.5F);

                // Spawn failure particles
                spawnFailureParticles((ServerWorld) world, user.getBlockPos());
            }

            if (user instanceof PlayerEntity player) {
                player.getItemCooldownManager().set(this, 395);
            }

            currentBlockPos = null;
        }
        return stack;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient && currentBlockPos != null) {
            // Emitir partículas continuamente enquanto o item está em uso
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(ParticleTypes.SMOKE, currentBlockPos.getX() + 0.5, currentBlockPos.getY() + 1.0, currentBlockPos.getZ() + 0.5, 1, 0.0, 0.0, 0.0, 0.1);

                // Tocar som contínuo
                serverWorld.playSound(null, currentBlockPos, SoundEvents.BLOCK_BEACON_AMBIENT, SoundCategory.PLAYERS, 0.3F, 1.0F);
            }
        }
        super.usageTick(world, user, stack, remainingUseTicks);
    }

    private void spawnSuccessParticles(ServerWorld world, BlockPos pos) {
        int numParticles = 20;
        for (int i = 0; i < numParticles; i++) {
            double offsetX = (world.random.nextDouble() - 0.5) * 0.6;
            double offsetY = world.random.nextDouble() * 0.6;
            double offsetZ = (world.random.nextDouble() - 0.5) * 0.6;

            world.spawnParticles(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5 + offsetX, pos.getY() + 1.0 + offsetY, pos.getZ() + 0.5 + offsetZ, 1, 0.0, 0.0, 0.0, 0.1);
        }
    }

    private void spawnFailureParticles(ServerWorld world, BlockPos pos) {
        int numParticles = 20;
        for (int i = 0; i < numParticles; i++) {
            double offsetX = (world.random.nextDouble() - 0.5) * 0.6;
            double offsetY = world.random.nextDouble() * 0.6;
            double offsetZ = (world.random.nextDouble() - 0.5) * 0.6;

            world.spawnParticles(ParticleTypes.ANGRY_VILLAGER, pos.getX() + 0.5 + offsetX, pos.getY() + 1.0 + offsetY, pos.getZ() + 0.5 + offsetZ, 1, 0.0, 0.0, 0.0, 0.1);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.doremitales.frequencyextractor.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.space.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.frequencyextractor.tooltip.description"));
        } else {
            tooltip.add(Text.translatable("tooltip.doremitales.frequencyextractor.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
