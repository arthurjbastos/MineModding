package net.doremista.item.custom;

import net.doremista.screen.EvelynLoreScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EvelynLoreItem extends Item {

    public EvelynLoreItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            openScreen();
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    @Environment(EnvType.CLIENT)
    private void openScreen() {
        MinecraftClient.getInstance().setScreen(new EvelynLoreScreen());
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.doremitales.evelynlore.tooltip"));
        tooltip.add(Text.translatable("tooltip.doremitales.evelynlore.tooltip_2"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
