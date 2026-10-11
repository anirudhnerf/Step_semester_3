package abstraction.class_problems;

// P4 demo: Smart Kitchen Assistant
public class SmartKitchenDemo {

    public static void main(String[] args) {
        Blender b = new Blender();
        b.setSpeedLevel(3);
        System.out.println("getSpeedLevel(): " + b.getSpeedLevel());

        b.setSpeedLevel(9); // outside 1-5
        System.out.println("setSpeedLevel(9): rejected, speed level stays " + b.getSpeedLevel());

        System.out.println(b.prepare());
        System.out.println(b.clean());
    }
}