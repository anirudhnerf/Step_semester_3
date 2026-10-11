package abstraction.class_problems;

// P3 demo: Orchestra Warm-Up Routine
public class OrchestraDemo {

    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        System.out.println(s.play());

        Violin v = new Violin();
        System.out.println(v.play());
    }
}