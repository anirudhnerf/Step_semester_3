package abstraction.class_problems;

// P1 demo: The Talking Toy Box
public class ToyBoxDemo {

    public static void main(String[] args) {
        // Toy generic = new Toy("Mystery");
        // ^ does not compile: "Toy is abstract; cannot be instantiated"

        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound());

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}