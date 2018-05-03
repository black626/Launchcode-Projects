package com.company;

/*
This class is an attempt at trying the 'Factory Design Pattern'.
It takes an integer sent to it and makes a pyramid out of it, aligned to the right.
The output is in the form of a String.
 */

public class Pyramid
{
    public String makePyramid(int number)
    {
        int variable = 20+number; //This number is what we'll base the spacing on during the loop.
        int upperBound = variable + 2;
        StringBuilder result = new StringBuilder(); //Efficient to append each char to a StringBuilder.

        //Creates a number of lines for 'drawing' as defined by 'n'.
        for (int i = 0; i < number; i++)
        {
            //Saves our spaces.
            for (int j = 0; j < variable; j++)
            {
                result.append(' ');
            }
            //Saves our #'s.
            for (int k = 0; k < (upperBound-variable); k++)
            {
                result.append('#');
            }
            variable--; //We negatively increment this so that our spaces will go down as our amount of #'s go up.
            //Sets the pyramid to a new line:
            if (i < (number-1)) //(With the exception of the last line)
            {
                result.append('\n');
            }
        }

        return result.toString();
        //Stringbuilder already has a .toString override function to suit our needs.
    }


    /*@Override
    public String toString()
    {

    }*/
}
