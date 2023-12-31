package wtf.norma.nekito.module;

import wtf.norma.nekito.module.impl.combat.*;
import wtf.norma.nekito.module.impl.hud.*;
import wtf.norma.nekito.module.impl.legit.*;
import wtf.norma.nekito.module.impl.movement.*;
import wtf.norma.nekito.module.impl.other.*;
import wtf.norma.nekito.module.impl.visuals.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ModuleManager {

    public static ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        addAll(
                new Sprint(),
                new Autoarmor(),
                new ClickGUI(),
                new Cape(),
                new FogColor(),
                new NoServerRotations(),
                new AntiVoid(),
                new AntiCrash(),
                new Arrows(),
                new TargetStrafe(),
                new FastMine(),
                new ItemPhysics(),
                new NoFall(),
                new KeepSprint(),
                new Fly(),
                new FastWorldLoad(),
                new NoSlowDown(),
                new HitBox(),
                new FullBright(),
                new CustomButtons(),
                new CustomModel(),
                new EntityESP(),
                new TargetHUD(),
                new Eagle(),
                new PolishHat(),
                new Strafe(),
                new ServerInfo(),
                new Tickbase(),
                new Velocity(),
                new InventorySettings(),
                new eleczkamode(),
                new ChestESP(),
                new bandytakamera(),
                new NoClip(),
                new NevaLose(),
                new NevaLoseinfo(),
                new WorldColor(),
              //  new CrashGUI(),
                new AntiBot(),
                new Watermark(),
                new AirJump(),
                new Autogapple(),
                new Watermark2(),
                new Arraylist(),
                new AutoClicker(),
                new Timer(),
                new AimBot(),
                new NoWeather(),
                new Reach(),
                new CustomHotbar(),
                new UiSettings(),
                new Criticals(),     //TODO: Implement it with some type of event
                new PacketDebugger(),
                new TimeChanger(),
                new Speed(),
                new Stealer(),
                new Wings(),
                new Ears(),
//                new LagDetector(), TODO:Fix this shit it's fucking broken
                new TriggerBot(),
                new KillAura(),
                new CustomDisabler()
        );
    }


    public void addAll(Module... modules) {
        ModuleManager.modules.addAll(Arrays.asList(modules));
    }

    public Module getModuleByName(String name) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public <T extends Module> T getModule(Class<T> clas) {
        return (T) getModules().stream().filter(module -> module.getClass() == clas).findFirst().orElse(null);
    }



    public ArrayList<Module> getModules() {
        return modules;
    }
}
