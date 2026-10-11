package abstraction.class_problems;

// P4: extends ONE abstract class and implements ONE interface
public class Blender extends KitchenTool implements Washable {

    public Blender() {
    }

    @Override
    public String prepare() {
        return "Blending at speed " + getSpeedLevel();
    }

    @Override
    public String clean() {
        return "Blender rinsed and dried";
    }
}