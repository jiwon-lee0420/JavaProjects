/**
 * Represents a Suspect object that extends from POI.
 * Difference is that Suspects have a height.
 * @author jlee3937
 * @version 1.0
 */
public class Suspect extends PersonOfInterest {
    private int height;
    /**
     * Constructor that takes in hair color,
     * proximity, rubber duck, and height.
     * @param hairColor hair color of Suspect.
     * @param proximity proximity of Suspect.
     * @param rubberDuck rubber duck of Suspect.
     * @param height height of Suspect.
     */
    public Suspect(Color hairColor, int proximity, RubberDuck rubberDuck, int height) {
        super(hairColor, proximity, rubberDuck);
        if (height < 150) {
            this.height = 150;
        } else {
            this.height = height;
        }
    }
    /**
     * Less specific constructor that defaults hair color
     * to BLONDE and height to 160.
     * @param proximity proximity of Suspect.
     * @param rubberDuck rubber duck of Suspect.
     */
    public Suspect(int proximity, RubberDuck rubberDuck) {
        this(Color.BLONDE, proximity, rubberDuck, 160);
    }
    /**
     * Represents a Suspect as a String that is easy to read.
     * @return a way to read off instance variables of a Suspect object.
     */
    public String toString() {
        return "Possible Suspect: " + super.toString()
               + "They were observed to be " + this.height
               + " cm tall.";
    }
    /**
     * Determines whether two Suspects are equal or not
     * depending on their hair color, proximity, rubber duck,
     * and height.
     * @param obj the Object that gets compared to the instance
     * of a Suspect object.
     * @return t or f depending on whether they are equal or not.
     */
    @Override
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
    /**
     * Returns the rubber duck of the Suspect.
     * @return super.getRubberDuck()
     */
    public RubberDuck getRubberDuck() {
        return super.getRubberDuck();
    }
}
