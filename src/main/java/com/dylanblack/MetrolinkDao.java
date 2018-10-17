package com.dylanblack;/*
com.dylanblack.MetrolinkDao interface is designed to handle instantiation and modification of our com.dylanblack.SQLiteJDBCDao
class.
 */

import java.util.List;

public interface MetrolinkDao
{
    List<String> getAllUniqueStops();
    String getNextTimeOfStop(String stopName);
}
