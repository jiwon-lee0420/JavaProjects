public class Brawler extends SuperheroRecruit{
    private Catchphrase() catchphrase;
    public Brawler(String name, int speed, double strength, int intelligence, Catchphrase catchphrase){
        super(name, speed, strength, intelligence);
        this.catchphrase = catchphrase;
    }
    public Brawler(String name, int speed){
        this(name, speed, 220, 100, null);
    }
    public Brawler(Brawler brawler){
        String phrase = brawler.getCatchphraseObj().getCatchphrase();
        double stat = brawler.getCatchphraseObj().getStatIncrease();
        Catchphrase catchphrase = new Catchphrase(phrase, stat);
        this(brawler.name, brawler.speed, brawler.strength, brawler.intelligence, catchphrase);
    }
    public double powerScaling(){
        double scale = (this.speed + this.strength + this.intelligence) / 3;
        if(this.catchphrase != null){
            scale = scale * (this.catchphrase.getStatIncrease() / 100);
            return scale;
        }
        return scale;
    }
    public Catchphrase getCatchphraseObj(){
        return this.catchphrase;
    }
}