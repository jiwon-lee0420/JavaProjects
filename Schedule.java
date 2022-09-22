import java.util.Scanner;

/**
 * The Schedule class that generates schedules and computes/compares the difficulty of said schedules.
 * @author Jiwon Lee
 * @version 1.0
 */
public class Schedule {
    /**
     * Main method for Schedule that creates two randomly generated schedules.
     * Computes the difficulties of the schedules and compares them using static methods.
     * @param args used to generate the main method
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of classes: ");
        int numClasses = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter this schedule's owner's name: ");
        String owner = scan.nextLine();
        String[] subjectList = {"English", "History", "Math", "cs", "Science", "Engineering", "Lab"};
        String[] schedule1 = generateSchedule(subjectList, numClasses);
        int[] difficulty1 = computeDifficulties(schedule1, subjectList);
        String[] schedule2 = generateSchedule(subjectList, numClasses);
        int[] difficulty2 = computeDifficulties(schedule2, subjectList);
        System.out.println("Schedules created successfully. Here are the details:");
        System.out.printf("Owner: %s \nNumber of Classes: %d\n", owner, numClasses);
        System.out.println("Schedule 1: ");
        for (int i = 0; i < schedule1.length; i++) {
            System.out.printf("%s %d\n", schedule1[i], difficulty1[i]);
        }
        System.out.println("Schedule 2: ");
        for (int i = 0; i < schedule2.length; i++) {
            System.out.printf("%s %d\n", schedule2[i], difficulty2[i]);
        }
        compareDifficulties(schedule1, schedule2, subjectList);
    }
    /**
     * Generates a random schedule when called.
     * @param subjectList a String array that holds the whole collection of subjects
     * @param numClasses an int that describes the number of classes that is to be made in the schedule
     * @return schedule: the randomly made schedule using this method
     */
    public static String[] generateSchedule(String[] subjectList, int numClasses) {
        String[] schedule = new String[numClasses];
        for (int i = 0; i < schedule.length; i++) {
            if (i % 2 == 0) {
                schedule[i] = subjectList[(int) (Math.random() * 4)];
            } else {
                schedule[i] = subjectList[(int) (Math.random() * 3) + 4];
            }
        }
        return schedule;
    }
    /**
     * Creates an aray of integers that represents the difficulty of each class.
     * @param schedule a String array that holds the subjects of a certain schedule
     * @param subjectList a String array that holds the whole collection of subjects
     * @return result: an array of integers that contains the difficulties of each class in the schedule
     */
    public static int[] computeDifficulties(String[] schedule, String[] subjectList) {
        int[] result = new int[schedule.length];
        int i = 0;
        for (String subject : schedule) {
            int j = 0;
            while (!subject.equals(subjectList[j])) {
                j++;
            }
            result[i] = i + j;
            i++;
        }
        return result;
    }
    /**
     * Takes two schedules and compares the total difficulties of the two schedules.
     * @param schedule1 the first schedule to be compared
     * @param schedule2 the second schedule that will be compared with the first
     * @param subjectList a String array that holds the whole collection of possible subjects
     */
    public static void compareDifficulties(String[] schedule1, String[] schedule2, String[] subjectList) {
        int[] difficulty1 = computeDifficulties(schedule1, subjectList);
        int totaldiff1 = 0;
        for (int i = 0; i < difficulty1.length; i++) {
            totaldiff1 += difficulty1[i];
        }
        int[] difficulty2 = computeDifficulties(schedule2, subjectList);
        int totaldiff2 = 0;
        for (int i = 0; i < difficulty2.length; i++) {
            totaldiff2 += difficulty2[i];
        }
        if (totaldiff1 > totaldiff2) {
            System.out.println("The first schedule is harder than the second schedule.");
        } else if (totaldiff1 < totaldiff2) {
            System.out.println("The second schedule is harder than the first schedule.");
        } else {
            System.out.println("The two schedules are equally difficult.");
        }
    }
}