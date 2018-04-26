package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Prints our Mario pyramid to a file.
public class FilePrint implements PrintSwitch
{
    public void operation(int number)
    {
        String fileName = "output.txt"; //output text file
        int variable = 20+number; //This number is what we'll base the spacing on during the loop.
        int upperBound = variable + 2;
        try
        {
            PrintWriter outputStream = new PrintWriter(fileName);
            //Creates a number of lines for 'drawing' as defined by 'n'.
            for (int i = 0; i < number; i++)
            {
                //Prints our spaces.
                for (int j = 0; j < variable; j++)
                {
                        outputStream.print(" ");
                }
                //Prints our #'s.
                for (int k = 0; k < (upperBound-variable); k++)
                {
                        outputStream.print("#");
                }
                variable--; //We negatively increment this so that our spaces will go down as our amount of #'s go up.
                //This is simply to reset the printer to the next line.
                if (i < number-1)
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
