package wtf.norma.nekito.module.impl;

import org.lwjgl.input.Keyboard;
import wtf.norma.nekito.module.Module;
import wtf.norma.nekito.nekito;


public class NevaLose extends Module {
    public NevaLose() {
        super("NevaLose", Category.HUD, Keyboard.KEY_NONE);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        nekito.INSTANCE.getDraggableManager().<wtf.norma.nekito.draggable.impl.NevaLose>Get("NevaLose").AllowRender = true;
    }


    @Override
    public void onDisable() {
        super.onDisable();
        nekito.INSTANCE.getDraggableManager().<wtf.norma.nekito.draggable.impl.NevaLose>Get("NevaLose").AllowRender = false;
    }
}