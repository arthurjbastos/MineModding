package net.doremista.block.custom;

import net.minecraft.block.AbstractBlock;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CarnationBlock extends FlowerBlock {

    public CarnationBlock(AbstractBlock.Settings settings) {
        super(StatusEffects.REGENERATION, 10, settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);

        // Emite partículas de tempos em tempos
        if (random.nextInt(10) == 0) { // Ajuste a frequência aqui
            world.addParticle(ParticleTypes.HAPPY_VILLAGER,
                    pos.getX() + 0.5,
                    pos.getY() + 1.0,
                    pos.getZ() + 0.5,
                    0.0, 0.0, 0.0);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.doremitales.carnation.tooltip"));
        tooltip.add(Text.translatable("tooltip.doremitales.carnation.tooltip_2"));
        super.appendTooltip(stack, world, tooltip, options);
    }

}
