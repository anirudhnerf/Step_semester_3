package abstraction.class_problems;

// P3: second level of the hierarchy
public class StringInstrument extends Instrument {

    public StringInstrument() {
        super();
    }

    // NOTE: the task says to call super.play() here, but Instrument.play() is abstract
    // (it has no body), and Java does not allow calling an abstract method through super.
    // So this level supplies the base message itself; Violin then builds on it.
    @Override
    public String play() {
        return "Strumming the strings";
    }
}