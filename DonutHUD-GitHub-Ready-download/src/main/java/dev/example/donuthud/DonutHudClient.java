package dev.example.donuthud;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;

public final class DonutHudClient implements ClientModInitializer {
    private static final int PANEL = 0xB8121420;
    private static final int ACCENT = 0xFFB56CFF;
    private static final int TEXT = 0xFFF3F0FA;
    private static final int MUTED = 0xFFB9B2C7;

    @Override
    public void onInitializeClient() {
        HudElementRegistry.addLast(
            Identifier.fromNamespaceAndPath("donut_hud", "main_hud"),
            (graphics, tickCounter) -> {
                Minecraft mc = Minecraft.getInstance();
                if (mc.player == null || mc.level == null || mc.options.hideGui) {
                    return;
                }

                int x = 8;
                int y = 8;
                int width = 150;
                int height = 78;

                BlockPos pos = mc.player.blockPosition();
                String facing = mc.player.getDirection().getName().toUpperCase();
                String dimension = getDimensionName(mc.level);
                String fps = Integer.toString(mc.getFps());

                graphics.fill(x, y, x + width, y + height, PANEL);
                graphics.fill(x, y, x + 3, y + height, ACCENT);
                graphics.drawString(mc.font, "DONUT HUD", x + 10, y + 7, ACCENT, false);
                graphics.drawString(mc.font, "XYZ  " + pos.getX() + " / " + pos.getY() + " / " + pos.getZ(),
                    x + 10, y + 22, TEXT, false);
                graphics.drawString(mc.font, "FACING  " + facing, x + 10, y + 34, MUTED, false);
                graphics.drawString(mc.font, "FPS  " + fps, x + 10, y + 46, MUTED, false);
                graphics.drawString(mc.font, dimension, x + 10, y + 58, MUTED, false);
            }
        );
    }

    private static String getDimensionName(Level level) {
        if (level.dimension() == Level.OVERWORLD) return "OVERWORLD";
        if (level.dimension() == Level.NETHER) return "NETHER";
        if (level.dimension() == Level.END) return "THE END";
        return level.dimension().identifier().toString().toUpperCase();
    }
}
