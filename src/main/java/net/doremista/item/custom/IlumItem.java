package net.doremista.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IlumItem extends Item {
    public IlumItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.doremitales.ilum.tooltip"));
            tooltip.add(Text.translatable("tooltip.doremitales.ilum.tooltip_2"));
        } else{
            tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
        }
    }
}
