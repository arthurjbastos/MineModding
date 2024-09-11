package net.doremista.mixin;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.item.BlockItem;

import java.util.List;

@Mixin(BlockItem.class)
public class JukeboxTooltipMixin {

    static {
        ItemTooltipCallback.EVENT.register((ItemStack stack, TooltipContext context, List<Text> lines) -> {
            // Verifica se o item é a Jukebox
            if (stack.isOf(Blocks.JUKEBOX.asItem())) {
                // Adiciona o tooltip personalizado
                lines.add(Text.translatable("tooltip.doremitales.jukebox.tooltip"));
                lines.add(Text.translatable("tooltip.doremitales.jukebox.tooltip_2"));
            }
        });
    }
}
