package wtf.norma.nekito.module.impl;

import org.lwjgl.input.Keyboard;
import wtf.norma.nekito.module.Module;
import wtf.norma.nekito.nekito;


public class Watermark extends Module {





    //  public static ModeSetting mode = new ModeSetting("Mode", "Nekito", "Nekito","wzrost");

    public Watermark() {
        super("Watermark", Category.HUD, Keyboard.KEY_NONE);
    }



    @Override
    public void onEnable() {
        nekito.INSTANCE.getDraggableManager().<wtf.norma.nekito.draggable.impl.Watermark>Get("Watermark").AllowRender = true;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        nekito.INSTANCE.getDraggableManager().<wtf.norma.nekito.draggable.impl.Watermark>Get("Watermark").AllowRender = false;
    }
}
