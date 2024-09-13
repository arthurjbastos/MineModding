package net.doremista.entity.custom;

import net.doremista.entity.ModEntities;
import net.doremista.entity.ai.RubberChickenAttackGoal;
import net.doremista.item.ModItems;
import net.doremista.sound.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;

import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class RubberChickenEntity extends AnimalEntity {

    public int eggLayTime;
    private int goldIngotCount = 0;
    private boolean hasReceivedIlumshard = false;


    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(RubberChickenEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public RubberChickenEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.eggLayTime = this.random.nextInt(6000) + 6000;

    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationTimeout--;
        }

        if (this.isAttacking() && this.attackAnimationTimeout <= 0) {
            this.attackAnimationTimeout = 40; // Duração da animação de ataque
            this.attackAnimationState.start(this.age);
        } else if (this.attackAnimationTimeout > 0) {
            this.attackAnimationTimeout--;
        } else {
            this.setAttacking(false); // Para garantir que a animação pare quando a entidade não está atacando
            this.attackAnimationState.stop();
        }

    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setupAnimationStates();
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && --this.eggLayTime <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(ModItems.RUBBEREGG);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.eggLayTime = this.random.nextInt(6000) + 6000;
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("EggLayTime")) {
            this.eggLayTime = nbt.getInt("EggLayTime");
        }
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("EggLayTime", this.eggLayTime);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new RubberChickenAttackGoal(this, 1.2, true));
        this.targetSelector.add(2, new RevengeGoal(this).setGroupRevenge());
        this.goalSelector.add(3, new AnimalMateGoal(this, 0.2));
        this.goalSelector.add(4, new TemptGoal(this, 1.0, Ingredient.ofItems(Items.CARROT), false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 4.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createRubberChickenAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ARMOR, 0.7f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.5);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (!player.getWorld().isClient()) {
            // Se o jogador der um ILUMSHARD
            if (itemStack.isOf(ModItems.ILUMSHARD) && !hasReceivedIlumshard) {
                hasReceivedIlumshard = true;
                itemStack.decrement(1); // Remove uma unidade do item

                // Feedback visual para o ILUMSHARD
                ((ServerWorld) this.getWorld()).spawnParticles(ParticleTypes.HAPPY_VILLAGER, this.getX(), this.getY() + 1, this.getZ(), 5, 0.5, 0.5, 0.5, 0.1);
                this.playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, random.nextFloat() * 0.1F + 0.9F);

                return ActionResult.SUCCESS;
            }

            // Se o jogador der uma barra de ouro
            if (itemStack.isOf(Items.GOLD_INGOT) && goldIngotCount < 7) {
                goldIngotCount++;
                itemStack.decrement(1); // Remove uma unidade do item

                // Feedback visual para cada barra de ouro
                ((ServerWorld) this.getWorld()).spawnParticles(ParticleTypes.HAPPY_VILLAGER, this.getX(), this.getY() + 1, this.getZ(), 5, 0.5, 0.5, 0.5, 0.1);
                this.playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, random.nextFloat() * 0.1F + 0.9F);

                return ActionResult.SUCCESS;
            }

            // Quando o mob receber 5 barras de ouro e 1 ILUMSHARD
            if (goldIngotCount >= 7 && hasReceivedIlumshard) {
                isImmobile();

                // 0.01% chance for an instant kill and jumpscare because why not funny hehe.
                Random random = new Random();
                if (random.nextDouble() < 0.001) {
                    // High-volume jumpscare sound
                    this.playSound(ModSounds.RUBBERCHICKEN_JUMPSCARE, 10.0F, 1.0F);

                    // Real explosion (using the mob's coordinates)
                    this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 9.0F, World.ExplosionSourceType.MOB);
                    this.remove(RemovalReason.DISCARDED);

                    return ActionResult.SUCCESS;
                }


                // Partículas de explosão
                ((ServerWorld) this.getWorld()).spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 10, 0.5, 0.8, 0.5, 0.1);

                // Toca o som de explosão
                this.playSound(ModSounds.RUBBERCHICKEN_DEATH, 1.0F, 1.0F);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 0.6F);

                // Dropar o item RUBBERTRUMPET
                this.dropStack(new ItemStack(ModItems.RUBBERTRUMPET));

                // Remove a entidade (despawns the mob)
                this.remove(RemovalReason.DISCARDED);

                return ActionResult.SUCCESS;
            }
        }

        return super.interactMob(player, hand);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }


    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        // Add custom particle effects if needed
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.CARROT);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.RUBBERCHICKEN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.RUBBERCHICKEN_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.RUBBERCHICKEN_HURT;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.RUBBERCHICKEN.create(world);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);

        if (!this.getWorld().isClient()) {
            Random random = new Random();

            //  Chance de 20% de dropar entre 1 e 2 penas
            double featherDropChance = 0.2;
            if (random.nextDouble() < featherDropChance) {
                int featherQuantity = random.nextInt(2) + 1; // 1 a 2
                ItemStack featherDrop = new ItemStack(Items.FEATHER, featherQuantity);
                this.dropStack(featherDrop);
            }

            //  Chance de 10% de dropar entre 1 a 2
            double carrotDropChance = 0.1;
            if (random.nextDouble() < carrotDropChance) {
                int carrotQuantity = random.nextInt(2) + 1; //
                ItemStack carrotDrop = new ItemStack(Items.CARROT, carrotQuantity);
                this.dropStack(carrotDrop);
            }
        }
    }
}
