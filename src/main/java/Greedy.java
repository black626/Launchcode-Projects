/**
 * User: mpmenne (edits by Dylan Black)
 * Date: 6/18/14 (6/17/18)
 * Time: 3:05 AM (8:07 PM)
 */

import org.junit.Test;

import java.util.Scanner;

public class Greedy {

    //Take an argument (string) and calculates the amount of change needed.
    public static void main(String[] args)
    {
        //unsure of how to use varArgs as our main method without first prompting user.
        /*if (varArgs.length > 1)
        {
            USCoinCalculator coinCalculator = new USCoinCalculator();
            coinCalculator.calculateChange(varArgs[0]);
        }
        throw new IllegalArgumentException("No value given");
        */

        //using a scanner instead:
        //Ask user for amount of change needed:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Greedy application!");
        System.out.println("Please enter the change amount, leading with a '$' or '€' sign.");
        String input = scanner.nextLine(); //Example: $3.27
        //error/ input check:
        while ((input.charAt(0) != '$') && (input.charAt(0) != '€'))
        {
          System.out.println("Please enter the change amount, leading with a '$' or '€' sign.");
          input = scanner.nextLine();
        }
        scanner.close(); //close scanner to save resources.
        char symbol = input.charAt(0); //Grabs $ or € sign
        Greedy greed = new Greedy(input, (symbol=='$'));
    }

    private USCoinCalculator usCC = new USCoinCalculator();
    private EUCoinCalculator euCC = new EUCoinCalculator();

    //constructor
    public Greedy(String in, boolean usCurrency)
    {
        int cents = Integer.parseInt(in.substring(in.length() - 2)); //grabs last two #'s
        int dollars = Integer.parseInt(in.substring(1, in.length() - 3)); //grabs #'s before '.##',
          //excludes the '$' sign
        if (usCurrency)
        {
          if (dollars != 0)
          {
            System.out.println("You will give back $" + dollars + " in bills.");
          }
          System.out.println(usCC.calculateChange(cents));
        }
        else if (!usCurrency)
        {
          if (dollars != 0)
          {
            System.out.println("You will give back €" + dollars + " coins.");
          }
          System.out.println(euCC.calculateChange(cents));
        }
    }
}
