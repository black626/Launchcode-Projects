/*
This class will handle all interaction with the database, so it can avoid bogging down main
(TrainData). It's main purpose is to connect to the interface, and then query it for the station
names.
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteJDBCDao implements MetrolinkDao
{
    public static final String JDBC_SQLITE_METROLINK_DB = "jdbc:sqlite:metrolink.db";
    public static final String ORG_SQLITE_JDBC = "org.sqlite.JDBC";

    private Connection conn = null;
    private String query;
    private PreparedStatement prepStatement;
    private ResultSet resultSet;

    private ScreenOutput screenOutput = new ScreenOutput();

    //Grabs all of our stops from the metrolink data. (Assumption: this method will always be
    // called before the others, hence why getConnection() is here.)
    public List<Stop> getStopsAllStops()
    {
      //Attempt to connect to our database first:
      try {
        getConnection();
      } catch (Exception e) {
        e.printStackTrace();
      }

      screenOutput.print("Fetching metrolink stations...");
      query = "Select * from metrolink_stops";//this will grab all stops (long list).
      try
      {
        prepStatement = conn.prepareStatement(query);
        resultSet = prepStatement.executeQuery();
        List<Stop> stops = new ArrayList<>();
        while (resultSet.next())
        {
          Stop currentStop = new Stop();
          currentStop.setStop_name(resultSet.getString("stop_name"));
          currentStop.setStopArrival_Time(resultSet.getString("arrival_time"));
          stops.add(currentStop);
        }
        return stops;
      }
      catch (SQLException e)
      {
        //Should only reach here if something goes awry.
        throw new RuntimeException("Error, exception.");
      }
    }

    //Outputs a list of all unique stops from our database.
    public List<String> getAllUniqueStops()
    {
      query = "Select Distinct stop_name from metrolink_stops where stop_name like '%METROLINK " +
        "STATION%' order by stop_name";
      List<String> uniqueStops = new ArrayList<>();
      try
      {
        prepStatement = conn.prepareStatement(query);
        resultSet = prepStatement.executeQuery();
        while (resultSet.next())
        {
          uniqueStops.add(resultSet.getString("stop_name"));
        }
      }
      catch (SQLException e)
      {
        //Just in case something breaks.
        throw new RuntimeException("Error, exception.");
      }
      return uniqueStops;
    }

    //Outputs a list of all unique times of a given Metrolink stop.
    public List<String> getAllTimesOfStop(String stopName)
    {
      query = "Select Distinct arrival_time from metrolink_stops where stop_name='"+stopName+"' " +
          "order by arrival_time";
      List<String> allTimesOfStop = new ArrayList<>();
      try
      {
        prepStatement = conn.prepareStatement(query);
        resultSet = prepStatement.executeQuery();
        while (resultSet.next())
        {
          allTimesOfStop.add(resultSet.getString("arrival_time"));
        }
      }
      catch (SQLException e)
      {
        throw new RuntimeException("Error, exception.");
      }
      return allTimesOfStop;
    }

    //Connects to our database.
    private Connection getConnection() throws Exception
    {
      try
      {
        Class.forName(ORG_SQLITE_JDBC);

        conn = DriverManager.getConnection(JDBC_SQLITE_METROLINK_DB);
        System.out.println("Connection successful."); //Just a check to make sure we connect.
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
      return conn;
    }
}
