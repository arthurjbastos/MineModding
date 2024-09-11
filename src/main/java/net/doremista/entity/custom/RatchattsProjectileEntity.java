package net.doremista.entity.custom;

import net.doremista.entity.ModEntities;
import net.doremista.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageSource;

import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class RatchattsProjectileEntity extends ThrownItemEntity {

    public RatchattsProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public RatchattsProjectileEntity(PlayerEntity player, World world) {
        super(ModEntities.RATCHATTS_PROJECTILE, player, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.RATCHATTS;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    // Causar dano em entidades
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (entityHitResult.getEntity() instanceof LivingEntity) {
            LivingEntity target = (LivingEntity) entityHitResult.getEntity();
            float damage = 7.0F; // Dano que o machado vai causar

            // Aplicar dano usando DamageTypes.THROWN
            target.damage(new DamageSources((DynamicRegistryManager) this.getWorld()).create(DamageTypes.THROWN, this.getOwner()), damage);

            // Dropar o machado no local da colisão
            ItemStack droppedStack = new ItemStack(ModItems.RATCHATTS);
            droppedStack.setDamage(droppedStack.getDamage() + 1); // Reduz a durabilidade

            // Dropa o item no local onde a entidade foi atingida
            this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), droppedStack));
        }

        // Remover a entidade do mundo
        this.discard();
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        // Dropar o machado no local da colisão com o bloco
        ItemStack droppedStack = new ItemStack(ModItems.RATCHATTS);
        droppedStack.setDamage(droppedStack.getDamage() + 1); // Reduz a durabilidade

        // Dropa o item no local onde o bloco foi atingido
        this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), droppedStack));

        // Remover a entidade do mundo
        this.discard();
        super.onBlockHit(blockHitResult);
    }
}
