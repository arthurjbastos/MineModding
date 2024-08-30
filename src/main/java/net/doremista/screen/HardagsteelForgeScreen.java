package net.doremista.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.doremista.Doremitales;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HardagsteelForgeScreen extends HandledScreen<HardagsteelForgeScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(Doremitales.MOD_ID, "textures/gui/hardagsteel_forge_gui.png");

    public HardagsteelForgeScreen(HardagsteelForgeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 99999;
        playerInventoryTitleY = 99999;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        // Draw the background texture
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // Render progress arrow
        renderProgressArrow(context, x, y);

        // Render fire animation
        renderFireAnimation(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if (handler.isCrafting()) {
            // Draw the progress arrow texture
            context.drawTexture(TEXTURE, x + 85, y + 30, 176, 0, 8, handler.getScaledProgress());
        }
    }

    private void renderFireAnimation(DrawContext context, int x, int y) {
        if (handler.isCrafting()) {
            int fireHeight = handler.getFireScaledProgress();
            int fireTextureY = 26 + (14 - fireHeight); // 26 é o Y inicial na textura, 14 é a altura total do fogo

            // Desenhar a parte visível da textura do fogo
            context.drawTexture(TEXTURE, x + 27, y + 31 + (14 - fireHeight), 176, fireTextureY, 14, fireHeight); // Posição 1
            context.drawTexture(TEXTURE, x + 135, y + 31 + (14 - fireHeight), 176, fireTextureY, 14, fireHeight); // Posição 2
        }
    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
