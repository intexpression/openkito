package wtf.norma.nekito.module.impl.hud;

import org.lwjgl.input.Keyboard;
import wtf.norma.nekito.module.Module;
import wtf.norma.nekito.Nekito;


public class NevaLoseinfo extends Module {
    public NevaLoseinfo() {
        super("NevaLose Info", Category.HUD, Keyboard.KEY_NONE);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Nekito.INSTANCE.getDraggableManager().<wtf.norma.nekito.draggable.impl.NevaLoseinfo>Get("NevaLoseinfo").AllowRender = true;
    }


    @Override
    public void onDisable() {
        super.onDisable();
        Nekito.INSTANCE.getDraggableManager().<wtf.norma.nekito.draggable.impl.NevaLoseinfo>Get("NevaLoseinfo").AllowRender = false;
    }
}
