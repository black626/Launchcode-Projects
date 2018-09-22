package com.dylanblack.launccodemario;

/*
This class is an attempt at trying the 'Factory Design Pattern'.
It takes an integer sent to it and makes a pyramid out of it, aligned to the right.
The output is in the form of a String.
 */

public class Pyramid
{

    //Constructor of our 'Pyramid' class, made up of a 'textline' stringbuilder.
    private static StringBuilder textline;
    private static int lines;
    private static Pyramid pyramid;

    public Pyramid(int number)
    {
      textline = new StringBuilder();
      lines = number;
    }

    /*
    //"Getter" method from Singleton design pattern for reference:
    public static Pyramid getInstance()
    {
      if (pyramid == null)
      {
        pyramid = new Pyramid(0);
      }
      return pyramid;
    }
    */

    public Pyramid makePyramid()
    {
        int variable = 20+lines; //This number is what we'll base the spacing on during the loop.
        int upperBound = variable + 2;

        //Creates a number of lines for 'drawing' as defined by 'n'.
        for (int i = 0; i < lines; i++)
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
            if (i < (lines-1)) //(With the exception of the last line)
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
