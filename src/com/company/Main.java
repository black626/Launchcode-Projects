package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
	    int number;
        Scanner reader = new Scanner(System.in); //Initialize scanner for input
	    System.out.println("Welcome to the Mario program!");
        System.out.println("How many lines do you want the pyramid to be? (0-23)");
        number = (int) reader.nextDouble(); //Just in case our user accidentally puts in a double.
	    //While number is out of our wanted bounds:
	    while (number > 23 || number < 0)
        {
            System.out.println("How many lines do you want the pyramid to be? (0-23)");
            number = (int) reader.nextDouble(); //Just in case our user accidentally puts in a double.
        }
        reader.close(); //Close scanner to save resources

        MarioPrint(number);
    }

    //This function accepts our user inputted number, and makes a mario-style pyramid out of it.
    public static void MarioPrint(int n)
    {
        int variable = 20+n; //This number is what we'll base the spacing on during the loop.
        int upperBound = variable + 2;
        //Creates a number of lines for 'drawing' as defined by 'n'.
        for (int i = 0; i < n; i++)
        {
            //Prints our spaces.
            for (int j = 0; j < variable; j++)
            {
                System.out.print(" ");
            }
            //Prints our #'s.
            for (int k = 0; k < (upperBound-variable); k++)
            {
                System.out.print("#");
            }
            variable--; //We negatively increment this so that our spaces will go down as our amount of #'s go up.
            System.out.println(); //This is simply to reset the printer to the next line.
        }
    }
}
