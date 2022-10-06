public class FlyingHero extends SuperheroRecruit {
    private double altitude;
    public FlyingHero(String name, int speed, double strength, int intelligence, double altitude){
        super(name, speed, strength, intelligence);
        if(altitude > 100 || altitude < 10){
            this.altitude = 50;
        } else{
            this.altitude = altitude;
        }
    }
    public FlyingHero(String name, int speed) {
        this(name, speed, 220, 100, 50);
    }
    public FlyingHero(String name) {
        this(name, 20, 220, 100, 50);
    }
    public FlyingHero(FlyingHero hero) {
        this(hero.name, hero.speed, hero.strength, hero.intelligence, hero.altitude);
    }
    public double powerScaling() {
        return (this.speed, this.strength, this.intelligence) / 3 + this.altitude;
    }
    public String toString(){
        return this.name + " can fly " + this.altitude + " feet in the air!";
    }
    public String recruit(String station){
        if(this.getTotalRecruits <= 0){
            return "Cannot recruit anyone, there are no slots left!";
        }
        if(powerScaling <= 120){
            return "Rejected. Take a look at our sidekick program!";
        }
        setTotalRecruits();
        return this.toString + this.name + " has " + this.intelligence + " IQ, runs at " + this.speed + 
               " miles per hour, and can lift " + this.strength + " pounds. The Power Scaling is " 
               + this.powerScaling() + ". Recruit is enlisted to " + station + ".";
    }
}