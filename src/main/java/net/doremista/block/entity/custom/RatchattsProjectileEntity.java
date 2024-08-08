package net.doremista.block.entity.custom;

import net.doremista.block.entity.ModEntities;
import net.doremista.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class RatchattsProjectileEntity extends ThrownItemEntity {
    private final ItemStack originalStack; // Campo para o item original

    public RatchattsProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
        this.originalStack = ItemStack.EMPTY; // Inicialize com um ItemStack vazio se não for usado
    }

    public RatchattsProjectileEntity(LivingEntity livingEntity, World world, ItemStack itemStack) {
        super(ModEntities.RATCHATTSPROJECTILE, livingEntity, world);
        this.originalStack = itemStack; // Armazene o item original
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            player.getInventory().removeOne(itemStack); // Remova o item do inventário do jogador
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.RATCHATTS;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()) {
            ItemStack itemStack = new ItemStack(this.getDefaultItem());
            this.dropStack(itemStack);
        }
        this.discard();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient()) {
            // Aplica dano à entidade atingida
            if (entityHitResult.getEntity() instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entityHitResult.getEntity();
                livingEntity.damage(getDamageSources().thrown(this, this.getOwner()), 8.6F); // 5.0F é o valor do dano
            }

            // Dropeia o item quando a entidade é atingida
            ItemStack itemStack = new ItemStack(this.getDefaultItem());
            this.dropStack(itemStack);
        }
        this.discard();
        super.onEntityHit(entityHitResult);
    }

    @Override
    public void tick() {
        super.tick();

        // Faz o projétil girar no ar
        this.setYaw(this.getYaw() + 20.0F); // Altere a rotação em torno do eixo Y (horizontal)
        this.setPitch(this.getPitch() + 10.0F); // Altere a rotação em torno do eixo X (vertical), se desejar
    }
}
