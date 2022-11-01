/**
 * Represents a RubberDuck object that is left as doorbells.
 * @author jlee3973
 * @version 1.0
 */
public class RubberDuck {
    private Color color;
    private boolean hasHat;
    /**
     * Constructor that takes in a Color and boolean
     * and instantiates instance variables.
     * @param color the color of the RubberDuck.
     * @param hasHat whether or not the RubberDuck has a hat or not.
     */
    public RubberDuck(Color color, boolean hasHat) {
        this.color = color;
        this.hasHat = hasHat;
    }
    /**
     * Constructor with no parameters.
     * Defaults color to yellow and hasHat to true.
     */
    public RubberDuck() {
        this(Color.YELLOW, true);
    }
    /**
     * returns an easy to read representation of a RubberDuck object.
     * @return a sentence form of a RubberDuck object.
     */
    public String toString() {
        return "a " + this.color + " rubber duck " + (hasHat? "with " : "without ") + "a hat.";
    }
    /**
     * Determines if two RubberDuck objects are equal.
     * If passed in object is not a RubberDuck, method returns false.
     * @return t or f depending on whether two RubberDuck objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RubberDuck) {
            RubberDuck o = (RubberDuck) obj;
            return this.color.equals(o.color) && this.hasHat == o.hasHat;
        }
        return false;
    }
    /**
     * Returns the color of a RubberDuck object.
     * @return this.color.
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * Returns whether or not a RubberDuck object has a hat or not.
     * @return this.hasHat.
     */
    public boolean getHasHat() {
        return this.hasHat;
    }
}