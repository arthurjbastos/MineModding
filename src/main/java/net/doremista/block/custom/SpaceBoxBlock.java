package net.doremista.block.custom;

import net.doremista.block.entity.ModBlockEntities;
import net.doremista.block.entity.SpaceBoxBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.doremista.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class SpaceBoxBlock extends Block implements BlockEntityProvider {
    public SpaceBoxBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SpaceBoxBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            SpaceBoxBlockEntity blockEntity = (SpaceBoxBlockEntity) world.getBlockEntity(pos);
            if (blockEntity != null && blockEntity.canDropItems()) {
                // Criar a entidade do item e posicioná-la acima do bloco
                ItemStack itemStack = new ItemStack(ModItems.KIKIANMASS);
                ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5, itemStack);

                // Adicionar a entidade ao mundo
                world.spawnEntity(itemEntity);

                // Tocar som de "pop"
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1.0F, 1.0F);

                // Incrementar a contagem de usos
                blockEntity.incrementUsage();
            }else {
                // Adicionar uma única partícula de fumaça quando não há mais itens para pegar
                if (world instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5, 1, 0.0, 0.0, 0.0, 0.1);
                }
                // Tocar um som opcional para indicar que não há mais itens
                world.playSound(null, pos, SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
        return ActionResult.SUCCESS;
    }

}
