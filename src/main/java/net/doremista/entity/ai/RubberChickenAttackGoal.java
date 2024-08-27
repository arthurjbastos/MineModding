package net.doremista.entity.ai;

import net.doremista.entity.custom.RubberChickenEntity;
import net.minecraft.entity.LivingEntity;
import net.doremista.sound.ModSounds;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;

public class RubberChickenAttackGoal extends MeleeAttackGoal {
    private final RubberChickenEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public RubberChickenAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((RubberChickenEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 20;
    }

    @Override
    protected void attack(LivingEntity pEnemy, double pDistance) {
        boolean isEnemyCloseEnough = isEnemyWithinAttackDistance(pEnemy, pDistance);

        if (isEnemyCloseEnough) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if (isTimeToAttack()) {
                performAttack(pEnemy);
            } else {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistance) {
        return pDistance <= this.getSquaredMaxAttackDistance(pEnemy) * 2.50; // TODO
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);

        this.mob.playSound(ModSounds.RUBBERCHICKEN_ATTACK, 1.0F, 1.0F);  // Som customizado

        if (this.mob.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(
                    ParticleTypes.SONIC_BOOM,  // O tipo de partícula que você quer emitir
                    this.mob.getX(),            // Coordenada X da posição do mob
                    this.mob.getBodyY(1.0),     // Coordenada Y, ajustada para a altura do mob
                    this.mob.getZ(),            // Coordenada Z da posição do mob
                    1,                         // Quantidade de partículas
                    0.1, 0.1, 0.1,              // Deslocamento das partículas
                    0.5                         // Velocidade das partículas
            );
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}