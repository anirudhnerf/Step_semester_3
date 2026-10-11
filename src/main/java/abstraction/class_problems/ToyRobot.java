package abstraction.class_problems;

// P1: another kind of toy, with a different sound
public class ToyRobot extends Toy {

    public ToyRobot(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return getName() + ": Beep boop!";
    }
}