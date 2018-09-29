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

    private static Connection conn = null;
    private static String query;

    //private AppOutput appOutput = new AppOutput();
    private ScreenOutput screenOutput = new ScreenOutput();

    //Grabs all of our stops from the metrolink data.
    public List<Stop> getStopsAllStops()
    {
      //Attempt to connect to our database first:
      try {
        getConnection();
      } catch (Exception e) {
        e.printStackTrace();
      }

      screenOutput.print("Fetching metrolink stations...");
      query = "Select Distinct stop_name from metrolink_stops where stop_name like '%METROLINK " +
          "STATION%' order by stop_name";
      try
      {
        PreparedStatement prepStatement = conn.prepareStatement(query);
        ResultSet resultSet = prepStatement.executeQuery();
        //System.out.println("Successful SQL Query.");     //Just a checkpoint.
        List<Stop> stops = new ArrayList<Stop>();
        while (resultSet.next())
        {
          Stop currentStop = new Stop();
          currentStop.setStop_name(resultSet.getString("stop_name"));
          stops.add(currentStop);
          //System.out.println(resultSet.getString("stop_name"));     //Manual printing to console.
        }
        return stops;
      }
      catch (SQLException e)
      {
        //Should only reach here if something goes awry.
        throw new RuntimeException("Error, exception.");
      }
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
