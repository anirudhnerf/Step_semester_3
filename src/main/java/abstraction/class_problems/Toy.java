package abstraction.class_problems;

// P1: abstract - there is no such thing as a generic toy, so new Toy(...) cannot compile
public abstract class Toy {

    // ONE counter shared by every Toy, whichever subclass builds it
    private static int toysCreated = 0;

    private final String toyId; // final: assigned once, in the constructor
    private final String name;

    // Every subclass reaches this through super(), so the counter lives in one place
    public Toy(String name) {
        this.name = name;
        toysCreated++;
        this.toyId = "TOY-" + (1000 + toysCreated);
    }

    public String getToyId() {
        return toyId;
    }

    public String getName() {
        return name;
    }

    // Each kind of toy MUST supply its own sound
    public abstract String makeSound();
}