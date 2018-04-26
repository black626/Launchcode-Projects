package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
	    int number; //number of lines to use
	    boolean filePrint; //determines if we print to output file or not
        Scanner reader = new Scanner(System.in); //Initialize scanner for input
	    System.out.println("Welcome to the Mario program!");
        System.out.println("How many lines do you want the pyramid to be? (0-23)");
        number = (int) reader.nextDouble(); //Just in case our user accidentally puts in a double. (Cast to int)
	    //While number is out of our wanted bounds, ask user again:
	    while (number > 23 || number < 0)
        {
            System.out.println("How many lines do you want the pyramid to be? (0-23)");
            number = (int) reader.nextDouble(); //Just in case our user accidentally puts in a double.
        }

        System.out.println("Do you want to print the output to a separate file? (Y/N)");
	    char answer = reader.next().charAt(0); //This will save answer as either 'y' or 'n', regardless if user answered
        //with 'yes', 'no', 'Y', or 'N'
        if (Character.toLowerCase(answer) == 'y') //yes, user wants to print to a separate file.
        {
            filePrint = true;
        }
        else //assume user entered 'no', 'n', or some other answer (i.e. 'maybe')
        {
            filePrint = false;
        }
        reader.close(); //Close scanner to save resources

        //Initialize our printer/ MarioPrinter.
        MarioPrint printer = new MarioPrint();
        if (filePrint)
        {
            printer.setPrintMethod(new FilePrint());
        }
        else
        {
            printer.setPrintMethod(new ConsolePrint());
        }
        printer.operation((number));
    }
}
