package net.doremista.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class SpaceBoxBlockEntity extends BlockEntity {
    private int usageCount = 0;
    private final int MAX_USAGE; // Número máximo de itens que podem ser pegos

    public SpaceBoxBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPACE_BOX_BLOCK_ENTITY, pos, state);

        // Inicializa maxUsage com um número aleatório entre 5 e 15
        Random random = new Random();
        this.MAX_USAGE = 6 + random.nextInt(15); // 5 + [0, 10], ou seja, entre 5 e 15

    }

    public void incrementUsage() {
        if (usageCount < MAX_USAGE) {
            usageCount++;
            markDirty(); // Marca o bloco como alterado para garantir que o estado seja salvo
        }
    }

    public boolean canDropItems() {
        return usageCount < MAX_USAGE;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        usageCount = nbt.getInt("UsageCount");
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("UsageCount", usageCount);
    }
}
