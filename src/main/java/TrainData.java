/*
Main class for running our app.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

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
    List<Stop> allStops = sqlConnection.getStopsAllStops();
    //"Cosmetic" printing of our ouput (station names, in this case)
    screenOutput.print("----------------------------------------");
    screenOutput.print("|" + StringUtils.center("STOP_NAME", 40) + "|");
    screenOutput.print("----------------------------------------");
    for (Stop stop : allStops) //For each 'stop' in allStops List:
    {
      screenOutput.print(String.format("|%40s|", StringUtils.center(stop.getStop_name(), 40)));
    }
    screenOutput.print("----------------------------------------");
  }
}
