package com.dylanblack.launccodemario;

/*
This class is an attempt at trying the 'Factory Design Pattern'.
It takes an integer sent to it and makes a pyramid out of it, aligned to the right.
The output is in the form of a String.
 */

public class Pyramid
{

    //Constructor of our 'Pyramid' class, made up of a 'textline' stringbuilder.
    private StringBuilder textline;
    public Pyramid()
    {
      textline = new StringBuilder();
    }

    private static Pyramid pyramid;

    //"Getter" method for Singleton design pattern:
    public static Pyramid getInstance()
    {
      if (pyramid == null)
      {
        pyramid = new Pyramid();
      }
      return pyramid;
    }

    public Pyramid makePyramid(int number)
    {
        int variable = 20+number; //This number is what we'll base the spacing on during the loop.
        int upperBound = variable + 2;

        //Creates a number of lines for 'drawing' as defined by 'n'.
        for (int i = 0; i < number; i++)
        {
            //Saves our spaces.
            for (int j = 0; j < variable; j++)
            {
                textline.append(' ');
            }
            //Saves our #'s.
            for (int k = 0; k < (upperBound-variable); k++)
            {
                textline.append('#');
            }
            variable--; //We negatively increment this so that our spaces will go down as our amount of #'s go up.
            //Sets the pyramid to a new line:
            if (i < (number-1)) //(With the exception of the last line)
            {
                textline.append('\n');
            }
        }

        return pyramid;
    }

    public String toString()
    {
      return pyramid.textline.toString();
    }

}
