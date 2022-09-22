import java.util.Random;
import java.util.Scanner;

/**
 * The PokemonBattle class that represents a Pokemon Battle.
 * @author Jiwon Lee
 * @version 1.0
  */
public class PokemonBattle {
    /**
    *  Main method for PokemonBattle that runs the do-while game loop.
    *  It also creates all the variables and calculations.
    *  @param args of Strings called 'args'
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        String rival;
        String myPokemon;
        double rivalHealth = round(rand.nextInt(21) + 40);

        System.out.print("Enter your Pokemon's nickname: ");
        myPokemon = scan.nextLine();
        myPokemon.trim();

        System.out.print("Enter your rival Pokemon's nickname: ");
        rival = scan.nextLine();
        rival.trim();

        System.out.printf("Your rival has chosen %s to fight, which has %.2f health.\n", rival, rivalHealth);

        int turns = 0;
        do {
            AttackType attack = AttackType.values()[rand.nextInt(3)];
            double total;
            if (attack == AttackType.SCRATCH) {
                int numScratch = rand.nextInt(2) + 1;
                double dmg = round((rand.nextDouble() * 5) + 1);
                total = numScratch * dmg;
            } else if (attack == AttackType.SURF) {
                total = round((rand.nextDouble() * 9) + 2);
            } else {
                total = round((rand.nextDouble() * 2) + 7);
            }

            rivalHealth -= total;

            System.out.printf("%s used %s and did %.2f damage. Your rival has "
                              + (rivalHealth > 0 ? "%.2f health remaining.\n" : "0.00 health remaining.\n"),
                               myPokemon, attack, total, rivalHealth);
            turns++;
        } while (rivalHealth > 0);

        System.out.printf("%s fainted after %d turns!\n", rival, turns);

        double prize = round((rand.nextDouble() * -1200) + 2400);
        System.out.printf("You have earned $%.2f!\n", prize);
    }
    /**
    *  A round method that is used to round doubles to two decimal points.
    *  @param a double that is a decimal that will be rounded
    *  @return the result of the rounding the double to two decimal digits
     */
    public static double round(double a) {
        double result = a * 100;
        result = Math.round(result);
        result = result / 100;
        return result;
    }
}