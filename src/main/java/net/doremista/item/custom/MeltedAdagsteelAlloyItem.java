package net.doremista.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MeltedAdagsteelAlloyItem extends Item {

    public MeltedAdagsteelAlloyItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFireproof() {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            // A cada 100 ticks (5 segundos) o jogador recebe 1 de dano
            if (world.getTime() % 50 == 0) {
                player.damage(world.getDamageSources().onFire(), 0.5f); // Causa 1 de dano ao jogador
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
