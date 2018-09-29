/*Goal of this class is to output our string of values and arrange it to look like a table,
similar to how sql will output data, given that header is on, and column is the current mode.
EXAMPLE:

---------------------------------------------------------------
|stop_name                                                     |
---------------------------------------------------------------
|Stop 1                                                        |
|Stop 2                                                        |
|Stop 3                                                        |
---------------------------------------------------------------

Note: This class is designed specifically for the output of metrolink stops, and as such,
it is not modular. (Will not work with several columns)
*/

public class ScreenOutput implements AppOutput
{
  public void print(String output)
  {
    System.out.println(output);
    //System.out.println(String.format("|%-30s|", output));
  }
}
