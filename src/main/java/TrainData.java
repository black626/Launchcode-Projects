//Main class for running our app.

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.time.LocalTime;

public class TrainData
{

  private ScreenOutput screenOutput = new ScreenOutput();

  public static void main(String[] args) throws Exception
  {
    //Spring accessibility, grab bean:
    ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
    TrainData trainData = (TrainData) appContext.getBean("trainDataApp1");

    trainData.runApp(); //Execution
  }

  private void runApp()
  {
    SQLiteJDBCDao sqlConnection = new SQLiteJDBCDao();
    List<Stop> allStops = sqlConnection.getStopsAllStops();     //List of ALL of our stops.
    List<String> allStopNames = sqlConnection.getAllUniqueStops();//List of unique stop names.
    //~COSMETIC~ print of our metrolink stops:
    screenOutput.print("----------------------------------------");
    screenOutput.print("|" + StringUtils.center("STOP_NAME", 40) + "|");
    screenOutput.print("----------------------------------------");
    for (String stop : allStopNames) //For each 'stop' in allStops List:
    {
      screenOutput.print(String.format("|%40s|", StringUtils.center(stop, 40)));
    }
    screenOutput.print("----------------------------------------");

    //Query user as to what station they're at:
    Scanner reader = new Scanner(System.in);
    screenOutput.print("Of these, which station are you currently located at?");
    String answer = reader.nextLine().toUpperCase();
    List<String> arrival_Times = new ArrayList<>();//List of all our arrival times for this stop.
    boolean nameCheck = false;
    while (!nameCheck)
    {
      for (Stop stop : allStops)
      {
        if (stop.getStop_name().compareTo(answer) == 0) //compare the two strings.
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
    arrival_Times = sqlConnection.getAllTimesOfStop(answer);
    screenOutput.print("Registered your stop.");

    //Get the current time, compare, and let the user know when the next arrival time at their
    // stop is.
    LocalTime today = LocalTime.now();
    String nextStop = findNextTime(arrival_Times);
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

  //This method compares the current time against a list of times to see when the next closest
  // time is.
  private String findNextTime (List<String> checkAgainst)
  {
    LocalTime currentTime = LocalTime.now(); //Current time.
    //LONG if statement, but in a nutshell, it checks if a given time from the list is after
    // our current time by checking the hour and minute.
    //For checking times in current hour:
    for (String str : checkAgainst)
    {
      if (Integer.parseInt(str.substring(0,2)) == currentTime.getHour())
      {
        if (Integer.parseInt(str.substring(3,5)) >= currentTime.getMinute())
        {
          return str; //since checkAgainst is already ordered by time, return first case that passes.
        }
      }
    }

    //Should only reach here if we must check the next hour for a close time.
    for (String str : checkAgainst)
    {
      //check only next hour:
      if (Integer.parseInt(str.substring(0,2)) == (currentTime.getHour()+1))
      {
        //Check minute difference, adding +60 to compensate for the hour.
        if ((Integer.parseInt(str.substring(3,5))+60) >= currentTime.getMinute())
        {
          return str; //since checkAgainst is already ordered by time, return first case that passes.
        }
      }
    }
    return null; //Shouldn't reach this point.
  }
}
