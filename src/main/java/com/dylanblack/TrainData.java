package com.dylanblack;//Main class for running our app.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.time.LocalTime;

//@ComponentScan("com.dylanblack")
@Component (value = "trainData")
public class TrainData
{
  @Autowired
  private ScreenOutput screenOutput;

  public static void main(String[] args) throws Exception
  {
    //Spring accessibility, grab bean:
    ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
    TrainData trainData = (TrainData) appContext.getBean("trainData");

    trainData.runApp(); //Execution
  }

  private void runApp()
  {
    SQLiteJDBCDao sqlConnection = new SQLiteJDBCDao();
    //List<Stop> allStops = sqlConnection.getStopsAllStops();     //List of ALL of our stops.
    List<String> allStopNames = sqlConnection.getAllUniqueStops();//List of unique stop names.
    //~COSMETIC~ print of our metrolink stops:
    screenOutput.printStops(allStopNames);

    //Query user as to what station they're at:
    Scanner reader = new Scanner(System.in);
    screenOutput.print("Of these, which station are you currently located at?");
    String answer = reader.nextLine().toUpperCase();
    boolean nameCheck = false;
    //Check user's answer to our list of stop names:
    while (!nameCheck)
    {
      for (String stopName : allStopNames)
      {
        if (stopName.compareTo(answer) == 0) //compare the two strings.
        {
          nameCheck = true;
          break;
        }
      }
      if (!nameCheck)
      {
        //name input of current stop doesn't match any of our stops in allStops list.
        screenOutput.print("Cannot find that stop. Please list one from the list above.");
        answer = reader.nextLine().toUpperCase(); //re-record answer.
      }
    }
    reader.close(); //Close our scanner to save resources.
    //Get the time of the next stop for our station.
    String nextStop = sqlConnection.getNextTimeOfStop(answer);
    //arrival_Times = sqlConnection.getAllTimesOfStop(answer);
    screenOutput.print("Registered your stop.");

    //Get the current time, compare, and let the user know when the next arrival time at their
    // stop is.
    LocalTime today = LocalTime.now();
    //String nextStop = findNextTime(arrival_Times);
    int minutes = Integer.parseInt(nextStop.substring(3,5));
    //If next time is into the next hour, add +60 minutes to compensate.
    if (today.getHour() < Integer.parseInt(nextStop.substring(0,2)))
    {
      minutes += 60;
    }
    int difference = minutes-today.getMinute();
    //Tell the user the time until the next train:
    if (difference > 0)
    {
      screenOutput.print("The next train is arriving in " + (difference + " minute(s)" +
          "."));
    }
    else if (difference == 0)
    {
      screenOutput.print("The train is currently at your station, departing soon.");
    }
    else
    {
      screenOutput.print("Unexpected error calculating next train arrival time.");
    }
  }
}
