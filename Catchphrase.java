public class Catchphrase{
    private String catchphrase;
    private double statIncrease;
    public Catchphrase(String catchphrase, double statIncrease) {
        if(catchphrase.equals("") || catchphrase == null){
            this.catchphrase = "I can do this all day";
        } else {
            this.catchphrase = catchphrase;
        }
        if(statIncrease <= 0 || statIncrease > 20){
            this.statIncrease = 15;
        } else {
            this.statIncrease = statIncrease;
        }
    }
    public String toString(){
        return this.catchphrase + "! Stats are increased by " + this.statIncrease + "%.";
    }
    public setCatchphrase(String catchphrase){
        this.catchphrase = catchphrase;
    }
    public setStatIncrease(double increase){
        this.statIncrease = increase;
    }
    public String getCatchphrase(){
        return this.catchphrase;
    }
    public double getStatIncrease(){
        return this.statIncrease;
    }
}