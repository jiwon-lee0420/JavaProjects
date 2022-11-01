/**
 * Represents an Accomplice object that extends from POI class.
 * Difference between Accomplice and POI is that Accomplices can code.
 * @author jlee3973
 * @version 1.0
 */
public class Accomplice extends PersonOfInterest {
    private boolean canCode;
    /**
     * Constructor that takes in hair color, proximity,
     * rubber duck, and whether accomplice can code or not.
     * @param hairColor hair color of Accomplice.
     * @param proximity proximity of Accomplice.
     * @param rubberDuck rubber duck of Accomplice.
     * @param canCode whether or not Accomplice can code.
     */
    public Accomplice(Color hairColor, int proximity, RubberDuck rubberDuck, boolean canCode) {
        super(hairColor, proximity, rubberDuck);
        this.canCode = canCode;
    }
    /**
     * Represents an Accomplice object as a String.
     * @return a way to read off instance variables of an Accomplice object.
     */
    public String toString() {
        return "Possible Accomplice: " + super.toString() + " They "
               + (this.canCode ? "do " : "do not ") + "have the ability to hack doorbells.";
    }
    /**
     * Determines whether two Accomplice objects are equal or not
     * depending on hair color, proximity, rubber duck, and whether
     * they can code or not.
     * @param obj the object that gets compared to an Accomplice instance.
     * @return t or f depending on whether or not they are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Accomplice) {
            Accomplice o = (Accomplice) obj;
            return this.getHairColor().equals(o.getHairColor())
                   && this.getProximity() == o.getProximity()
                   && this.getRubberDuck().equals(o.getRubberDuck())
                   && (this.canCode == o.canCode);
        }
        return false;
    }
    /**
     * Returns the rubber duck of the accomplice.
     * @return this.getRubberDuck().
     */
    public RubberDuck getRubberDuck() {
        return super.getRubberDuck();
    }
    /**
     * Returns whether or not the accomplice can code.
     * @return this.canCode.
     */
    public boolean getCanCode() {
        return this.canCode;
    }
}