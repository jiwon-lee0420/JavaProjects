import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Party {
    public static ArrayList<PartyMember> recruitParty(String file) throws FileNotFoundException{
        ArrayList<PartyMember> pm = new ArrayList<PartyMember>();
        File dir = new File(".");
        File f = new File(dir.getPath() + file);
        if (f == null || !f.canRead()) {
            throw new FileNotFoundException("The file is nonexistent...");
        }
        Scanner scan = new Scanner(f);
        while(scan.hasNextLine()) {
            if (scan.nextLine().isEmpty())
                continue;
            pm.add(processInfo(scan.nextLine()));
        }
        return pm;
    }
    private static PartyMember processInfo(String info) throws IllegalArgumentException, InvalidPartyMemberException {
        String split[] = info.split(":");
        for (int i = 0; i < split.length; ++i) {
            split[i] = split[i].trim().split(",")[0];
            System.out.println(split[i]);
        }
        if (split[2] == null || split[2].equals("")) {
            throw new IllegalArgumentException("Invalid name input!!");
        }
        if (Integer.parseInt(split[3]) > 100 || Integer.parseInt(split[3]) < 0) {
            throw new IllegalArgumentException("Invalid health input!!");
        }
        if (Integer.parseInt(split[4]) < 0 || Integer.parseInt(split[4]) > Integer.parseInt(split[3]) * 2) {
            throw new IllegalArgumentException("Invalid base attack input!!");
        }
        if (split[1].equals("Warrior")) {
            if (split[5] == null || split[5].equals("")) {
                throw new IllegalArgumentException("Invalid weapon input!!");
            }
            if (Integer.parseInt(split[6]) > 10 || Integer.parseInt(split[6]) < 0) {
                throw new IllegalArgumentException("Invalid armor class input!!");
            }
            return new Warrior(split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], Integer.parseInt(split[6]));
        } else if (split[1].equals("Mage")) {
            if (Integer.parseInt(split[5]) < Integer.parseInt(split[4]) || Integer.parseInt(split[5]) > Integer.parseInt(split[4]) * 2) {
                throw new IllegalArgumentException("Invalid spell attack input!!");
            }
            if (Integer.parseInt(split[6]) < 0 || Integer.parseInt(split[6]) > Integer.parseInt(split[3]) / 2) {
                throw new IllegalArgumentException("Invalid spell slot input!!");
            }
            return new Mage(split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]));
        } else {
            throw new InvalidPartyMemberException("Not a Warrior or Mage!(check for case)");
        }
    }
    public static boolean partyRoster(String file, ArrayList<PartyMember> pm) throws FileNotFoundException {
        File dir = new File("."); //you need to fix this later!!(thrown exceptions...)
        File outfile = new File(dir.getPath() + file);
        PrintWriter pw = new PrintWriter(outfile);
        if (outfile == null || !outfile.canWrite()) {
            throw new FileNotFoundException("Make sure to create file!");
        }
        for (int i = 0; i < pm.size(); ++i) {
            pw.println(pm.get(i));
            pw.flush();
        }
        pw.close();
        return true;
    }
    public static boolean getQuest(String quest, ArrayList<PartyMember> pm) throws FileNotFoundException{
        File dir = new File(".");
        File q = new File(dir.getPath() + "/quest.csv");
        if (q == null || !q.canRead()) {
            throw new FileNotFoundException("Quest file not found!");
        }
        Scanner scan = new Scanner(q);
        while (scan.hasNextLine()) {
            if (scan.nextLine().isEmpty())
                continue;
            
        }
    }
    private static int partyQuestLevel(ArrayList<PartyMember> pm) {
        if (pm == null || pm.size() == 0)
            return -1;
        int total = 0;
        for (PartyMember p : pm) {
            total += p.questLevel();
        }
        return total;
    }
    public static void main(String[] args) {
        String info = "Class: Warrior, Name: Warrior01, Health: 0, Base Attack: 0, Weapon: sword, Armor Class: 0";
        String split[] = info.split(":");
        for (int i = 0; i < split.length; ++i) {
            split[i] = split[i].trim().split(",")[0];
            System.out.println(split[i]);
        }
    }
}
