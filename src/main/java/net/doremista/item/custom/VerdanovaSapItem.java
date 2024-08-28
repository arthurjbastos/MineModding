package net.doremista.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VerdanovaSapItem extends Item {
    public VerdanovaSapItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.doremitales.verdanovasap.tooltip"));
        tooltip.add(Text.translatable("tooltip.doremitales.verdanovasap.tooltip_2"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
