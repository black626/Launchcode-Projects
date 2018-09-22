package com.dylanblack.launccodemario;

/*
This class is a factory for making Pyramids (so to speak), handling our creation and reference.
 */

public class PyramidFactory
{
  public static Pyramid Pyramid(int number)
  {
      //Create the Pyramid object:
      Pyramid pyramid = new Pyramid(number);
      //Generate the Pyramid's structure (StringBuilder)
      pyramid.makePyramid();
      return pyramid;
  }
}
