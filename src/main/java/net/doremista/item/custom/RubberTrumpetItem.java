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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RubberTrumpetItem extends Item {

    private static final int DAMAGE_INTERVAL = 14; // Dano a cada 1 segundo
    private static final double DAMAGE_RADIUS = 6.0;
    private static final float DAMAGE_AMOUNT = 2.1f;

    // Cooldown em ticks (exemplo: 100 ticks = 5 segundos)
    private static final int COOLDOWN_TIME = 100;

    private final Map<PlayerEntity, Boolean> playerSoundPlayingMap = new HashMap<>();

    public RubberTrumpetItem(Settings settings) {
        super(settings);
        // Registrar o evento de tick do servidor
        ServerTickEvents.END_WORLD_TICK.register(this::onTick);
    }

    private void onTick(ServerWorld world) {
        for (PlayerEntity player : world.getPlayers()) {
            ItemStack stack = player.getActiveItem();
            if (stack.getItem() instanceof RubberTrumpetItem) {
                // Dano aos mobs próximos
                damageNearbyMobs(world, player);
                playSoundContinuously(world, player);
            }
        }
    }

    private void damageNearbyMobs(ServerWorld world, PlayerEntity player) {
        // Checar se o jogador está usando o item
        if (player.getItemUseTime() % DAMAGE_INTERVAL == 0) {
            // Encontrar todos os mobs dentro do raio de alcance
            List<MobEntity> mobs = world.getEntitiesByClass(MobEntity.class,
                    player.getBoundingBox().expand(DAMAGE_RADIUS),
                    mob -> mob.isAlive() && mob.squaredDistanceTo(player) <= DAMAGE_RADIUS * DAMAGE_RADIUS);

            // Aplicar dano a cada mob
            for (MobEntity mob : mobs) {
                mob.damage(world.getDamageSources().playerAttack(player), DAMAGE_AMOUNT);

                // Partículas para efeito visual
                world.spawnParticles(ParticleTypes.SMALL_FLAME, mob.getX(), mob.getY() + 1, mob.getZ(), 8, 0.5, 0.5, 0.5, 0.1);
            }
        }
    }

    private void playSoundContinuously(ServerWorld world, PlayerEntity player) {
        // Toca o som continuamente enquanto o item está em uso
        if (playerSoundPlayingMap.getOrDefault(player, false)) {
            if (player.getItemUseTime() % 23 == 0) { // Tocar o som a cada 5 ticks (~0.25 segundos)
                float randomPitch = 0.5f + new Random().nextFloat();
                world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.RUBBERTRUMPET, SoundCategory.PLAYERS, 0.4f, randomPitch);
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        user.setCurrentHand(hand);
        if (!world.isClient) {
            playerSoundPlayingMap.put(user, true); // Começar a tocar o som continuamente
            // Aplicar o cooldown assim que o jogador começa a usar o item
            user.getItemCooldownManager().set(this, COOLDOWN_TIME);
        }

        return TypedActionResult.consume(itemStack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient && user instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) user;
            playerSoundPlayingMap.remove(player); // Parar o som quando o uso for interrompido

            // Reaplicar cooldown ao parar de usar, se necessário
            player.getItemCooldownManager().set(this, COOLDOWN_TIME);
        }
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000; // O item pode ser usado continuamente
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.doremitales.rubbertrumpet.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.space.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.rubbertrumpet.tooltip.description"));
            tooltip.add(Text.translatable("tooltip.doremitales.rubber.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.doremitales.rubbertrumpet.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
