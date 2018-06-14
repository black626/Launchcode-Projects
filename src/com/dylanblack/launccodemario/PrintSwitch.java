package com.dylanblack.launccodemario;

//This file is unnecessary for Factory Switch Method in PS3 branch. Please ignore it.

public interface PrintSwitch
{
    //This is our interface class, used as a default/ template for our ConsolePrint and FilePrint classes.
    //This states that the operation shared by these two classes must share the same input, 'number'.
    void operation(int number);
}
