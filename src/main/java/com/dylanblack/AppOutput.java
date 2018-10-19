package com.dylanblack;/*
com.dylanblack.AppOutput interface is designed to handle our instantiation and modification of com.dylanblack.ScreenOutput
classes.
 */

import java.util.List;

public interface AppOutput
{
    void print (String input);
    void printStops(List<String> allUniqueStops);
}
