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
        reader.close(); //Close scanner to save resources

        //Send answers to our 'pyramid factory' for output.
        String result = new Pyramid().makePyramid(number);
        System.out.println(result);
    }
}
