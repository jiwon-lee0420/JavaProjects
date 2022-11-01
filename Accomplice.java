/**
 * Represents an accomplice which extends from the POI class.
 * The difference between an accomplice and a POI is that they
 * are able to code.
 * @author jlee3973
 * @version 1.0
 */
public class Accomplice extends PersonOfInterest {
    private boolean canCode;
    /**
     * The only constructor that takes in hair color,
     * proximity, rubber duck, and whether or not they
     * can code.
     * @param hairColor hair color of the Accomplice.
     * @param proximity proximity of the Accomplice.
     * @param rubberDuck rubber duck of the Accomplice.
     * @param canCode whether or not Accomplice can code.
     */
    public Accomplice (Color hairColor, int proximity, RubberDuck rubberDuck, boolean canCode) {
        super(hairColor, proximity, rubberDuck);
        this.canCode = canCode;
    }
    /**
     * Turns an accomplice object into a readable String form.
     * @return a String that makes it easy to read off
     * instance variables of an Accomplice object.
     */
    public String toString() {
        return "Possible Accomplice: " + super.toString() + " They "
               + (this.canCode? "do ":"do not ") + "have the ability to hack doorbells.";
    }
    /**
     * Determines whether two Accomplice objects are equal or not
     * depending on their hair color, proximity, rubber duck, and
     * whether or not they can code.
     * @return t or f depending on whether they are equal or not.
     */
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
        return this.getRubberDuck();
    }
    /**
     * Returns whether or not the accomplice can code.
     * @return this.canCode.
     */
    public boolean getCanCode() {
        return this.canCode;
    }
}