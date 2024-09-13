package net.doremista.item.custom;

import net.doremista.sound.ModSounds;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AeonFluteItem extends Item {
    private static final int USAGE_DURATION_TICKS = 36; // Tempo de uso em ticks
    private static final int COOLDOWN_TICKS = 140; // Tempo de cooldown em ticks
    private static final int AI_RESTORE_DELAY = 50; // Tempo para restaurar a IA dos mobs em ticks (3 segundos)

    private final Map<MobEntity, Integer> mobRestoreMap = new HashMap<>();
    private final Map<PlayerEntity, Integer> playerUseMap = new HashMap<>();
    private final Map<PlayerEntity, Boolean> playerSoundPlayingMap = new HashMap<>();

    public AeonFluteItem(Settings settings) {
        super(settings);

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            mobRestoreMap.entrySet().removeIf(entry -> {
                int remainingTicks = entry.getValue() - 1;
                if (remainingTicks <= 0) {
                    entry.getKey().setAiDisabled(false);
                    return true;
                }
                entry.setValue(remainingTicks);
                return false;
            });

            playerUseMap.entrySet().removeIf(entry -> {
                PlayerEntity player = entry.getKey();
                int remainingTicks = entry.getValue() - 1;
                float randomPitch = 0.5f + new Random().nextFloat();

                // Toca o som continuamente enquanto o item está em uso
                if (remainingTicks % 5 == 0 && playerSoundPlayingMap.getOrDefault(player, false)) {
                    player.getWorld().playSound(null, player.getBlockPos(), ModSounds.AEONFLUTEPLAY, SoundCategory.PLAYERS, 1.0F, randomPitch);

                    // Iniciar partículas contínuas
                    World world = player.getWorld();
                    if (world instanceof ServerWorld serverWorld) {
                        serverWorld.spawnParticles(ParticleTypes.NOTE, player.getX(), player.getY() + 0.5, player.getZ(), 2, 0.5, 0.5, 0.5, 0.3);
                    }
                }

                if (remainingTicks <= 0) {
                    applyParalysisEffect(player.getWorld(), player);
                    player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS, 1.0F, 1.0f);
                    player.getItemCooldownManager().set(AeonFluteItem.this, COOLDOWN_TICKS);
                    ItemStack stack = player.getStackInHand(player.getActiveHand());
                    stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));

                    // Remove o som após o uso do item
                    playerSoundPlayingMap.remove(player);

                    return true;
                }
                entry.setValue(remainingTicks);
                return false;
            });
        });

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (playerUseMap.containsKey(user)) {
            return new TypedActionResult<>(ActionResult.FAIL, stack);
        }

        user.setCurrentHand(hand);
        if (!world.isClient) {
            playerUseMap.put(user, USAGE_DURATION_TICKS);
            playerSoundPlayingMap.put(user, true); // Marca o som como ativo
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient && playerUseMap.containsKey(user)) {
            playerUseMap.remove(user);

            // Remove o som quando o uso do item é interrompido
            if (user instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) user;
                playerSoundPlayingMap.remove(player);
            }
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return USAGE_DURATION_TICKS;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    private void applyParalysisEffect(World world, PlayerEntity player) {
        int radius = 5;
        world.getEntitiesByClass(MobEntity.class, player.getBoundingBox().expand(radius), mob -> true)
                .forEach(mob -> {
                    mob.setAiDisabled(true);
                    mobRestoreMap.put(mob, AI_RESTORE_DELAY);
                    if (world instanceof ServerWorld) {
                        spawnParticles((ServerWorld) world, mob);
                    }
                });
    }

    private void spawnParticles(ServerWorld world, LivingEntity entity) {
        int numParticles = 15;
        for (int i = 0; i < numParticles; i++) {
            double offsetX = (world.random.nextDouble() - 0.5) * 0.5;
            double offsetY = world.random.nextDouble();
            double offsetZ = (world.random.nextDouble() - 0.5) * 0.5;
            world.spawnParticles(ParticleTypes.GLOW, entity.getX() + offsetX, entity.getY() + offsetY, entity.getZ() + offsetZ, 2, 0.0, 0.0, 0.0, 0.1);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.doremitales.aeonflute.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.space.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.aeonflute.tooltip.description"));
            tooltip.add(Text.translatable("tooltip.doremitales.mutemagic.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.doremitales.aeonflute.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
