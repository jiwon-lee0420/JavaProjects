public class Suspect extends PersonOfInterest{
    private int height;
    public Suspect(Color hairColor, int proximity, RubberDuck rubberDuck, int height) {
        super(hairColor, proximity, rubberDuck);
        if (this.height < 150) {
            this.height = 150;
        } else {
            this.height = height;
        }
    }
    public Suspect(int proximity, RubberDuck rubberDuck) {
        this(Color.BLONDE, proximity, rubberDuck, 160);
    }
    public String toString() {
        return "Possible Suspect: " + super.toString()
               + "They were observed to be " + this.height
               + " cm tall.";
    }
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
    
}
