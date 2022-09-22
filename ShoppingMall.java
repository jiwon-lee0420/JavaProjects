/* Jiwon Lee
   I have a mild diabates */

public class ShoppingMall{
  public static void main(String[] args){
    String name = "Oswald";
    int cash = 100;
    float taxRate = 0.13F;
    float subtotal = 58.62F;
    float change = cash - subtotal - (subtotal * taxRate);
    change = ((int)(change * 100))/100.0F;
    System.out.println(name + " has $" + change + " dollars remaining! \n" + name + " started with $" + cash + " dollars!");
  }
}
