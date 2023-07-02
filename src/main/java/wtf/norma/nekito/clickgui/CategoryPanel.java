package wtf.norma.nekito.clickgui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import wtf.norma.nekito.module.Module;
import wtf.norma.nekito.nekito;
import wtf.norma.nekito.util.font.Fonts;
import wtf.norma.nekito.util.render.RenderUtility;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryPanel {
    private final Module.Category category;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Minecraft mc;
    private final List<ModuleButton> moduleButtons = new ArrayList<>();
    private boolean open = true;

    public CategoryPanel(Module.Category category, int x, int y, int width, int height, Minecraft mc) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.mc = mc;

        for (Module module : nekito.INSTANCE.getModuleManager().getModules()) {
            if (module.category == this.category) {
                moduleButtons.add(new ModuleButton(module, x, y, width, height, mc));
            }
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (this.open) {
            int offset = height;
            for (ModuleButton moduleButton : this.moduleButtons) {
                offset += moduleButton.drawScreen(mouseX, mouseY, partialTicks, offset);
            }
        }

        RenderUtility.drawRound(x - 1, y, width + 2, height - 1, 4, new Color(43, 92, 255));
        Fonts.SEMI_BOLD_18.drawString(category.name, x + 5, y + 5, -1);
        Fonts.SEMI_BOLD_18.drawString(open ? "-" : "+", x + 90, y + 5, -1);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        moduleButtons.forEach(moduleButton -> moduleButton.mouseClicked(mouseX, mouseY, mouseButton));

        if (bounding(mouseX, mouseY) && mouseButton == 1) this.open = !this.open;
    }

    public void keyTyped(char typedChar, int keyCode) {
        if (this.open) moduleButtons.forEach(moduleButton -> moduleButton.keyTyped(typedChar, keyCode));
    }


    public void mouseReleased(int mouseX, int mouseY, int state) {
        if (this.open)
            moduleButtons.forEach(moduleButton -> moduleButton.mouseReleased(mouseX, mouseY, state));
    }

    public boolean bounding(int mouseX, int mouseY) {
        if (mouseX < this.x) return false;
        if (mouseX > this.x + this.width) return false;
        if (mouseY < this.y) return false;
        return mouseY <= this.y + this.height;
    }
}
