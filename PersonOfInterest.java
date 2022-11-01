/**
 * Represents a PersonOfInterest that could have committed the crime.
 * @author jlee3973
 * @version 1.0
 */
public class PersonOfInterest implements Comparable<PersonOfInterest>{
    private Color hairColor;
    private int proximity;
    private RubberDuck rubberDuck;
    /**
     * Constructor that takes in a Color, proximity, and RubberDuck
     * and instantiates all instance variables.
     * @param hairColor hair color of POI.
     * @param proximity proximity of POI.
     * @param rubberDuck rubber duck of POI.
     */
    public PersonOfInterest(Color hairColor, int proximity, RubberDuck rubberDuck) {
        this.hairColor = hairColor;
        this.proximity = proximity;
        this.rubberDuck = rubberDuck;
    }
    /**
     * Less specific constructor that takes in proximity, and RubberDuck
     * and defaults hair color to blonde.
     * @param proximity proximity of POI.
     * @param rubberDuck rubber duck of POI.
     */
    public PersonOfInterest(int proximity, RubberDuck rubberDuck) {
        this(Color.BLONDE, proximity, rubberDuck);
    }
    /**
     * Represents a POI object as a String.
     * @return a POI represented by a String.
     */
    public String toString() {
        return "A POI with " + this.hairColor + " hair was last seen " + this.proximity
               + " miles away holding a " + this.rubberDuck.getColor() + " rubber duck "
               + (this.rubberDuck.getHasHat()? "with ":"without ") + "a hat.";
    }
    /**
     * Determines if two POI objects are equal depending on their
     * hair color, proximity, and rubber duck.
     * @param obj the object that gets compared.
     * @return t or f depending on whether the two POI objects are equal.
     */
    public boolean equals(Object obj) {
        if (obj.getClass().getName().equals("PersonOfInterest")) {
            PersonOfInterest o = (PersonOfInterest) obj;
            return this.hairColor.equals(o.hairColor)
                   && this.proximity == o.proximity
                   && this.rubberDuck.equals(o.rubberDuck);
        }
        return false;
    }
    /**
     * Returns an int depending on whether or not the two POI's are similar or not.
     * @param o the POI that gets compared.
     * @return an int depending on the qualities of the two POI's.
     */
    public int compareTo(PersonOfInterest o) {
        if (o == null) {
            return -1;
        }
        if (this.proximity == o.proximity) {
            return this.hairColor.compareTo(o.hairColor);
            
        } else if (this.proximity < o.proximity) {
            return -1;
        } else {
            return 1;
        }
    }
    /**
     * Returns the hair color of the POI.
     * @return this.hairColor.
     */
    public Color getHairColor() {
        return this.hairColor;
    }
    /**
     * Returns the proximity of the POI.
     * @return this.proximity.
     */
    public int getProximity() {
        return this.proximity;
    }
    /**
     * Returns the rubber duck of the POI.
     * @return this.rubberDuck.
     */
    public RubberDuck getRubberDuck() {
        return this.rubberDuck;
    }
}