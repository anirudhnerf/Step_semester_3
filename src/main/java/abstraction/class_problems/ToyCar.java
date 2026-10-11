package abstraction.class_problems;

// P1: one kind of toy, with its own sound
public class ToyCar extends Toy {

    public ToyCar(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return getName() + ": Vroom vroom!";
    }
}