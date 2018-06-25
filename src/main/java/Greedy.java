/**
 * User: mpmenne (edits by Dylan Black)
 * Date: 6/18/14 (6/17/18)
 * Time: 3:05 AM (8:07 PM)
 */

import org.junit.Test;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Greedy {

    private static String input;
    private static char symbol;

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
        input = scanner.nextLine(); //Example: $3.27
        //error/ input check:
        while ((input.charAt(0) != '$') && (input.charAt(0) != '€'))
        {
          System.out.println("Please enter the change amount, leading with a '$' or '€' sign.");
          input = scanner.nextLine();
        }
        scanner.close(); //close scanner to save resources.
        symbol = input.charAt(0); //Grabs $ or € sign

        //Load our xml application file, create beans (objects).
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        //Search for "greedy1" bean and grab it.
        Greedy obj = (Greedy) context.getBean("greedy1");
        obj.start();

        ((ClassPathXmlApplicationContext) context).close(); //close beans to save resources.
    }

    private USCoinCalculator usCC;
    private EUCoinCalculator euCC;

    //constructor w/ Dependency Injection
    public Greedy(USCoinCalculator usCC, EUCoinCalculator euCC)
    {
      this.euCC = euCC;
      this.usCC = usCC;
    }

    public void start()
    {
        int cents = Integer.parseInt(input.substring(input.length() - 2)); //grabs last two #'s
        int dollars = Integer.parseInt(input.substring(1, input.length() - 3)); //grabs #'s before '
        // .##', excludes the '$' sign
        if (symbol=='$') //US Currency.
        {
          if (dollars != 0)
          {
            System.out.println("You will give back $" + dollars + " in bills.");
          }
          System.out.println(usCC.calculateChange(cents));
        }
        else if (symbol!='$') //EU Currency.
        {
          if (dollars != 0 && dollars < 4)
          {
            System.out.println("You will give back €" + dollars + " coins.");
          }
          else if (dollars >= 5) //just a little joke.
          {
            System.out.println("You will give back €" + dollars + " coins. " +
                "(Might I suggest using a €5 bill or larger, instead?)");
          }
          System.out.println(euCC.calculateChange(cents));
        }
    }
}
