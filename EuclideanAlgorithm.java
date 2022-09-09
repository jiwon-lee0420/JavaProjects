public class EuclideanAlgorithm{
    public static void main(String[] args){
        int num1 = 50;
        int num2 = 25;
        int steps = 0;
        int dividend = num1;
        int divisor = num2;
        int gcd;
        int quotient;
        int remainder;

        System.out.printf("Finding the greatest common divisor of %d and %d \n", num1, num2);
        
        if(divisor > dividend){
            System.out.println("The inputs would have caused an unnecessary step.");
            int n = divisor;
            divisor = dividend;
            dividend = n;
        }
        else{
            System.out.println("An extra step was avoided");
        }

        do{
            steps++;
            quotient = dividend / divisor;
            remainder = dividend % divisor;
            System.out.printf("Step %d: %d = %d * %d + %d \n", steps, dividend, divisor, quotient, remainder);
            gcd = divisor;
            dividend = divisor;
            divisor = remainder;
        } while(remainder != 0);

        System.out.println("The GCD is " + gcd);

        switch(steps){
        case steps == 1:
            System.out.println("Only one step was needed!");
            break;
        case steps == 2:
            System.out.println("Two steps were taken!");
            break;
        case steps == 3:
            System.out.println("This process took three steps");
            break;
        case default:
            System.out.printf("%d steps is a lot of steps!", steps);
            break;
        }
        
        boolean pie = true;
        System.out.printf("I like to eat" + (pie ? "pie" : "poo")); 

    }
}