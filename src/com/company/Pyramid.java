package com.company;

public class Pyramid
{
    private char[][] lines; //Array of 'chars' to represent each line of the pyramid.

    public String makePyramid(int number)
    {
        int variable = 20+number; //This number is what we'll base the spacing on during the loop.
        int upperBound = variable + 2;
        lines = new char[number][upperBound]; //Instantiate [rows][columns] of 2D char array.

        //Creates a number of lines for 'drawing' as defined by 'n'.
        for (int i = 0; i < number; i++)
        {
            //Saves our spaces.
            for (int j = 0; j < variable; j++)
            {
                lines[i][j] = (' ');
            }
            //Saves our #'s. (Make sure to put them at the end of the spaces, hence why we do 'k+variable')
            for (int k = 0; k < (upperBound-variable); k++)
            {
                lines[i][k+variable] = ('#');
            }
            variable--; //We negatively increment this so that our spaces will go down as our amount of #'s go up.
        }
        return lines.toString();
    }


    @Override
    public String toString()
    {

        //StringBuilder result = new StringBuilder(); //More efficient to append each char to a StringBuilder.
        String result = "";
        for (int i = 0; i < lines.length; i++) //Go through each row
        {
            for (int j = 0; j <lines[0].length; j++) //Go through each column
                //Note: this only works because we know that our 2D array has a row @ [0], otherwise outOfBounds exception.
            {
                //result.append(lines[i][j]);
                result += lines[i][j];
            }
            result += "\n";
        }
        return (result);
    }
}
