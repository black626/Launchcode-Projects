package com.company;

public class MarioPrint implements PrintSwitch
{
    //This is our 'master switch' class.
    //It controls what operation we're doing, based on how main class sets the print method.

    private PrintSwitch controller;

    //Used to dynamically change method we're using to print.
    public void setPrintMethod(PrintSwitch controller)
    {
        this.controller = controller;
    }

    //Used to call fileprint and consoleprint with a given number of lines.
    public void operation(int number)
    {
        this.controller.operation(number);
    }
}
