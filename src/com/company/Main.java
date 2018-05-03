package com.company;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
This program takes a user-inputted amount of lines and makes a 'Mario-style' pyramid in response.
It can output to both the console, or an output file, determined by the user.
 */

public class Main {

    public static void main(String[] args)
    {
	    int number; //number of lines to use
        Scanner reader = new Scanner(System.in); //Initialize scanner for input
        String fileName = "output.txt"; //output text file

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
        //Check if user inputted correct answer (upper or lower case 'y' or 'n' will work)
        while (Character.toLowerCase(answer) != 'y' && Character.toLowerCase(answer) != 'n')
        {
            System.out.println("Do you want to print the output to a separate file? (Y/N)");
            answer = reader.next().charAt(0);
        }
        reader.close(); //Close scanner to save resources

        //Send answers to our 'pyramid factory' for output.
        String result = new Pyramid().makePyramid(number);

        //If we want to print to file:
        if (Character.toLowerCase(answer) == 'y')
        {
            try
            {
                PrintWriter outputStream = new PrintWriter(fileName);
                outputStream.print(result);
                outputStream.close();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        //Else, print to console.
        else
        {
            System.out.println(result);
        }
    }
}
