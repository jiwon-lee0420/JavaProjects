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
     * @param name
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
                    for (int k = 0; k < dupSus.size(); k++) {
                        if (dup.equals(dupSus.get(k))) {
                            break;
                        }
                        if (k == this.suspects.size() - 1) {
                            dupSus.add(dup);
                        }
                    }
                    this.suspects.remove(j);
                    j--;
                }
            }
        }
        return dupSus;
    }
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
    public Accomplice findMastermind(Suspect sus) {
        for (int i = 0; i < this.accomplices.size(); i++) {
            if (this.accomplices.get(i).getCanCode()
                && this.accomplices.get(i).getRubberDuck().equals(sus.getRubberDuck())) {
                return this.accomplices.get(i);
            }
        }
        return null;
    }
    public static void main (String[] args) {
        System.out.println(Color.BLONDE.compareTo(Color.BLONDE));
    }
}