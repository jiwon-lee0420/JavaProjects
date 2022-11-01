/**
 * Represents a Suspect which extends from the POI object.
 * Difference between Suspect and POI is that a Suspect has a height.
 * @author jlee3973
 * @version 1.0
 */
public class Suspect extends PersonOfInterest{
    private int height;
    /**
     * Constructor that takes in hair color, proximity,
     * rubber duck, and height of the Suspect.
     * @param hairColor hair color of the Suspect.
     * @param proximity proximity of the Suspect.
     * @param rubberDuck rubber duck of the Suspect.
     * @param height height of the Suspect.
     */
    public Suspect(Color hairColor, int proximity, RubberDuck rubberDuck, int height) {
        super(hairColor, proximity, rubberDuck);
        if (this.height < 150) {
            this.height = 150;
        } else {
            this.height = height;
        }
    }
    /**
     * Less specific constructor tat defaults hair
     * color to BLONDE and height to 160.
     * @param proximity proximity of the Suspect.
     * @param rubberDuck rubber duck of the Suspect.
     */
    public Suspect(int proximity, RubberDuck rubberDuck) {
        this(Color.BLONDE, proximity, rubberDuck, 160);
    }
    /**
     * Turns a Suspect into an easy to read String sentence.
     * @return an easy way to read off the instance variables of a Suspect object.
     */
    public String toString() {
        return "Possible Suspect: " + super.toString()
               + "They were observed to be " + this.height
               + " cm tall.";
    }
    /**
     * Determines whether two Suspect objects are equal or not.
     * Depending on hair color, proximity, rubber duck, and height.
     * @param obj the Object that gets compared to the Suspect object.
     * @return t or f depending on whether or not the two Suspect
     * objects are equal.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Suspect) {
            Suspect o = (Suspect) obj;
            return this.getHairColor().equals(o.getHairColor())
                   && this.getProximity() == o.getProximity()
                   && this.getRubberDuck().equals(o.getRubberDuck())
                   && this.height == o.height;
        }
        return false;
    }
    public RubberDuck getRubberDuck() {
        return this.getRubberDuck();
    }
}