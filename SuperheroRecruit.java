public class SuperheroRecruit{
    protected String name;
    private int speed;
    private double strength;
    private int intelligence;
    private static int totalRecruits = 10;

    public SuperheroRecruit(String name, int speed, double strength, int intelligence){
        if(name.equals("") || name == null){
            this.name = "Steve Rogers";
        } else{
            this.name = name;
        }
        
        if(speed < 0){
            this.speed = 20;
        } else{
            this.speed = speed;
        }
        
        if(strength < 0){
            this.strength = 220;
        } else{
            this.strength = strength;
        }

        if(intelligence < 0){
            this.intelligence = 100;
        } else{
            this.intelligence = intelligence;
        }
    }
    public SuperheroRecruit(String name, int speed, double strength){
        this(name, speed, strength, 100);
    }
    public SuperheroRecruit(String name, int speed){
        this(name, speed, 220, 100);
    }
    public SuperheroRecruit(SuperheroRecruit hero){
        this(hero.name, hero.speed, hero.strength, hero.intelligence);
    }
    public double powerScaling(){
        return (this.speed + this.strength + this.intelligence) / 3;
    }
    public String toString(){
        return this.name + " has " + this.intelligence + " IQ, runs at " + this.speed + 
               " miles per hour, and can lift " + this.strength + " pounds. The Power Scaling is " + this.powerScaling() + "."; 
    }
    public String recruit(String station){
        if(totalRecruits <= 0){
            return "Cannot recruit anyone, there are no slots left!";
        }
        if(powerScaling <= 120){
            return "Rejected. Take a look at our sidekick program!";
        }
        totalRecruits--;
        return this.toString() + "Recruit is enlisted to " + station + ".";
    }
    public int getTotalRecruits(){
        return totalRecruits;
    }
    public setTotalRecruits(){
        totalRecruits--;
    }
}