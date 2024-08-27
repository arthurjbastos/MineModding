package net.doremista.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ElephasticLoreScreen extends Screen {
    private static final Identifier TEXTURE = new Identifier("doremitales", "textures/gui/elephasticlore.png");
    private final int textureWidth = 236;
    private final int textureHeight = 308;

    public ElephasticLoreScreen() {
        super(Text.of("Lore Page"));
    }

    @Override
    protected void init() {
        super.init();
        // Centrando a GUI
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (this.width - textureWidth) / 2;
        int y = (this.height - textureHeight) / 2;

        // Desenhar a textura com a escala correta
        context.drawTexture(TEXTURE, x, y, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
