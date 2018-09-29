/*
MetrolinkDao interface is designed to handle instantiation and modification of our SQLiteJDBCDao
class.
 */

import java.util.List;

public interface MetrolinkDao
{
    List<Stop> getStopsAllStops();
}
