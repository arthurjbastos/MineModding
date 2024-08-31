package net.doremista.item.custom;

import net.doremista.item.ModItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class AdagsteelImbuedItem extends Item {

    public AdagsteelImbuedItem(Settings settings) {
        super(settings);
    }


    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        if (entity.getWorld().getBlockState(entity.getBlockPos()).getFluidState().isIn(FluidTags.LAVA)) {
            entity.getWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.PLAYERS, 1.0f, 1.0f);
            entity.getWorld().spawnEntity(new ItemEntity(entity.getWorld(), entity.getBlockPos().getX(), entity.getBlockPos().getY(), entity.getBlockPos().getZ(), new ItemStack(ModItems.MELTEDADAGSTEELALLOY)));
        }
    }

}
