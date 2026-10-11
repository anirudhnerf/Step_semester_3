package abstraction.class_problems;

// P4: abstract tool with a JavaBean speedLevel property that only accepts 1-5
public abstract class KitchenTool {

    private int speedLevel = 1; // private: only reachable through the getter/setter

    public abstract String prepare();

    public int getSpeedLevel() {
        return speedLevel;
    }

    // Reject first, assign second
    public void setSpeedLevel(int speedLevel) {
        if (speedLevel < 1 || speedLevel > 5) {
            return; // out of range: rejected, value stays as it was
        }
        this.speedLevel = speedLevel;
    }
}