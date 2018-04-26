package com.company;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

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

        MarioPrint(number, filePrint);
    }

    /*This function accepts our user inputted number, boolean to determine if writing to a text file,
    and makes a mario-style pyramid out of it. */
    public static void MarioPrint(int n, boolean printToFile)
    {
        String fileName = "output.txt"; //output text file
        int variable = 20+n; //This number is what we'll base the spacing on during the loop.
        int upperBound = variable + 2;
        try
        {
            PrintWriter outputStream = new PrintWriter(fileName);
            //Creates a number of lines for 'drawing' as defined by 'n'.
            for (int i = 0; i < n; i++)
            {
                //Prints our spaces.
                for (int j = 0; j < variable; j++)
                {
                    if (!printToFile) //output to console.
                    {
                        System.out.print(" ");
                    }
                    else if (printToFile) //output to file.
                    {
                        outputStream.print(" ");
                    }
                }
                //Prints our #'s.
                for (int k = 0; k < (upperBound-variable); k++)
                {
                    if (!printToFile) //output to console.
                    {
                        System.out.print("#");
                    }
                    else if (printToFile) //output to file.
                    {
                        outputStream.print("#");
                    }
                }
                variable--; //We negatively increment this so that our spaces will go down as our amount of #'s go up.
                //This is simply to reset the printer to the next line.
                if (!printToFile && i < n-1)
                {
                    System.out.println();
                }
                if (printToFile && i < n-1)
                {
                    outputStream.println();
                }
            }
            outputStream.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
