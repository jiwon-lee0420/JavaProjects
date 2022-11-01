import java.util.ArrayList;
/**
 * Represents a Police Station that has a name
 * and lists of suspects and accomplices.
 * @author jlee3973
 * @version 1.0
 */
public class PoliceStation {
    private String name;
    private ArrayList<Suspect> suspects;
    private ArrayList<Accomplice> accomplices;
    /**
     * Constructor that takes in name of Police Station.
     * Instantiates the suspects and accomplices list.
     * @param name the name of the Police Station.
     */
    public PoliceStation(String name) {
        this.name = name;
        this.suspects = new ArrayList<Suspect>();
        this.accomplices = new ArrayList<Accomplice>();
    }
    /**
     * Adds the POI to the suspects/accomplice list
     * depending on whether or not the input is a
     * suspect or accomplice.
     * @param person the POI to be added to the suspect/accomplice list.
     */
    public void addPersonOfInterest(PersonOfInterest person) {
        if (person instanceof Suspect) {
            Suspect suspect = (Suspect) person;
            this.suspects.add(suspect);
        } else if (person instanceof Accomplice) {
            Accomplice accomp = (Accomplice) person;
            this.accomplices.add(accomp);
        }
    }
    /**
     * Sorts the suspects in ascending order based on
     * proximity and hair color of Suspect object.
     */
    public void sortSuspects() {
        for (int i = 1; i < this.suspects.size(); i++) {
            int count = i;
            for (int j = i - 1; j >= 0; j--) {
                if (this.suspects.get(count).compareTo(this.suspects.get(j)) < 0) {
                    this.suspects.add(j, this.suspects.get(count));
                    this.suspects.remove(j + 2);
                    count--;
                }
            }
        }
    }
    /**
     * Removes any duplicates in the suspects list
     * and adds them to another list to show which ones
     * were duplicated.
     * @return a list of the duplicate suspects.
     */
    public ArrayList<Suspect> removeDuplicates() {
        ArrayList<Suspect> dupSus = new ArrayList<Suspect>();
        for (int i = 0; i < this.suspects.size(); i++) {
            Suspect dup = this.suspects.get(i);
            for (int j = i + 1; j < this.suspects.size(); j++) {
                if (dup.equals(this.suspects.get(j))) {
                    boolean exists = false;
                    for (int k = 0; k < dupSus.size(); k++) {
                        if (dup.equals(dupSus.get(k))) {
                            exists = true;
                        }
                    }
                    if (!exists) {
                        dupSus.add(this.suspects.get(j));
                    }
                    this.suspects.remove(j);
                    j--;
                }
            }
        }
        return dupSus;
    }
    /**
     * Finds suspects depending on whether or not
     * the hair color and proximity match according
     * to the given Suspect object.
     * @param obj a Suspect obj with distinct hair color
     * and proximity that gets compared to the Suspects in
     * suspects list.
     * @return a Suspect if found or null if not.
     */
    public Suspect findSuspect(Suspect obj) {
        this.removeDuplicates();
        this.sortSuspects();

        for (int i = 0; i < this.suspects.size(); i++) {
            if (this.suspects.get(i).compareTo(obj) == 0) {
                return this.suspects.get(i);
            }
        }
        return null;
    }
    /**
     * Finds the 'master mind'. If an accomplice
     * can code and has matching rubber duck with input
     * Suspect, then they are the master mind.
     * @param sus The suspect that has been caught
     * and claims that the 'master mind' has matching
     * rubber duck.
     * @return An accomplice that can code and has the same
     * rubber duck as sus. Returns null if nonexistent.
     */
    public Accomplice findMastermind(Suspect sus) {
        for (int i = 0; i < this.accomplices.size(); i++) {
            if (this.accomplices.get(i).getCanCode()
                && this.accomplices.get(i).getRubberDuck().equals(sus.getRubberDuck())) {
                return this.accomplices.get(i);
            }
        }
        return null;
    }
    /**
     * Main method that actually gets run in command prompt.
     * @param args the input in command prompt line.
     */
    public static void main(String[] args) {
        RubberDuck rd1 = new RubberDuck(Color.BLACK, false);
        RubberDuck rd2 = new RubberDuck();
        RubberDuck rd3 = new RubberDuck(Color.CYAN, true);
        RubberDuck rd4 = new RubberDuck(Color.GREEN, true);
        RubberDuck rd5 = new RubberDuck(Color.BROWN, false);
        Suspect s1 = new Suspect(Color.BLONDE, 20, rd1, 175);
        System.out.println(s1);
        Suspect s2 = new Suspect(Color.BLACK, 1, rd2, 162);
        Suspect s3 = new Suspect(Color.BROWN, 5, rd3, 200);
        Suspect s4 = new Suspect(Color.BLONDE, 15, rd4, 205);
        Suspect s5 = new Suspect(Color.BLONDE, 20, rd1, 175);
        Accomplice a1 = new Accomplice(Color.BLONDE, 20, rd1, true);
        Accomplice a2 = new Accomplice(Color.BROWN, 20, rd2, false);
        Accomplice a3 = new Accomplice(Color.RED, 25, rd3, true);
        Accomplice a4 = new Accomplice(Color.BLACK, 15, rd4, false);
        Accomplice a5 = new Accomplice(Color.BLONDE, 2, rd5, true);
        PoliceStation ps = new PoliceStation("Popo");
        ps.addPersonOfInterest(s1);
        ps.addPersonOfInterest(s2);
        ps.addPersonOfInterest(s3);
        ps.addPersonOfInterest(s4);
        ps.addPersonOfInterest(s5);
        ps.addPersonOfInterest(a1);
        ps.addPersonOfInterest(a2);
        ps.addPersonOfInterest(a3);
        ps.addPersonOfInterest(a4);
        ps.addPersonOfInterest(a5);
        ps.sortSuspects();
        ps.removeDuplicates();
        System.out.println(ps.findSuspect(s5));
        System.out.println(ps.findMastermind(s1));
    }
}