package com.dylanblack.launccodemario;

public class PyramidFactory
{
  private static Pyramid pyramid;

  public static String Pyramid(int number)
  {
      pyramid = new Pyramid(number);
      //pyramid.getInstance().makePyramid();
      pyramid.makePyramid();
      return pyramid.toString();
  }

}
