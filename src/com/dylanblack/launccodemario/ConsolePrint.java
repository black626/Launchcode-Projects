package com.dylanblack.launccodemario;

//This file is unnecessary for Factory Switch Method in PS3 branch. Please ignore it.

//Prints our Mario pyramid to the console.
public class ConsolePrint implements PrintSwitch
{
    public void operation(int number)
    {
        int variable = 20+number; //This number is what we'll base the spacing on during the loop.
        int upperBound = variable + 2;
        //Creates a number of lines for 'drawing' as defined by 'n'.
        for (int i = 0; i < number; i++)
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
            //This is simply to reset the printer to the next line.
            if ( i < number-1) //Just so we don't print an empty line at the end.
            {
                System.out.println();
            }
        }
    }
}
