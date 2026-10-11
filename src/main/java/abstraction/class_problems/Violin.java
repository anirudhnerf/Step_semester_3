package abstraction.class_problems;

// P3: third level - reuses StringInstrument's message and adds only its own detail
public class Violin extends StringInstrument {

    public Violin() {
        super();
    }

    @Override
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}