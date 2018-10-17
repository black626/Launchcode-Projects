package com.dylanblack;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScreenOutput implements AppOutput
{
  public void print(String output)
  {
    System.out.println(output);
  }

  public void printStops(List<String> allUniqueStops)
  {
    System.out.println("----------------------------------------");
    System.out.println("|" + StringUtils.center("STOP_NAME", 40) + "|");
    System.out.println("----------------------------------------");
    for (String stop : allUniqueStops) //For each 'stop' in allStops List:
    {
      System.out.println(String.format("|%40s|", StringUtils.center(stop, 40)));
    }
    System.out.println("----------------------------------------");
  }
}
