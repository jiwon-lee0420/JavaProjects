public class EuclideanAlgorithm{
    public static void main(String[] args){
        int num1 = 50;
        int num2 = 3;
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
        case 1:
            System.out.println("Only one step was needed!");
            break;
        case 2:
            System.out.println("Two steps were taken!");
            break;
        case 3:
            System.out.println("This process took three steps");
            break;
        default:
            System.out.printf("%d steps is a lot of steps!", steps);
            break;
        }

        System.out.printf("%d and %d" +(gcd ==1 ? " are relatively prime." : " are not relatively prime."), num1, num2); 

        String myString = "33333";
        myString.replace("3", "e");
        System.out.println(myString);
    }
}