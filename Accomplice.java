public class Accomplice extends PersonOfInterest {
    private boolean canCode;
    public Accomplice (Color hairColor, int proximity, RubberDuck rubberDuck, boolean canCode) {
        super(hairColor, proximity, rubberDuck);
        this.canCode = canCode;
    }
    public String toString() {
        return "Possible Accomplice: " + super.toString() + " They "
               + (this.canCode? "do ":"do not ") + "have the ability to hack doorbells.";
    }
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
}
