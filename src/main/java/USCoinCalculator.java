/**
 * User: mpmenne (edits by Dylan Black)
 * Date: 6/18/14 (6/17/18)
 * Time: 3:06 AM (Reminds me of all-nighters back in college.)
 */
public class USCoinCalculator implements CoinChange
{

    int[] coinCount; //Counts our list of coins so far.
    String[] coinNames; //List of our coins.
    StringBuilder output;
    int nonZeroCoinCount = 0; //counts our non-zero coins, used for grammatical output.

    private static USCoinCalculator usCC;

    //Constructor method.
    public USCoinCalculator()
    {
        coinCount = new int[4];
        //we count from largest to smallest coin in our array, so:
        //coinCount[0] are quarters.
        //coinCount[1] are dimes. (ext.)
        //list of our coins:
        coinNames = new String[4];
        coinNames[0] = "quarter";
        coinNames[1] = "dime";
        coinNames[2] = "nickel";
        coinNames[3] = "penn"; //short for penny, but spelling is different for singular/ plural.
        //Default leader for output:
        output = new StringBuilder("The shortest amount of change is ");
    }

    //Getter method.
    public static USCoinCalculator getInstance()
    {
      if (usCC == null)
      {
        usCC = new USCoinCalculator();
      }
      return usCC;
    }

    public String calculateChange(int change)
    {
        if (usCC == null)
        {
          usCC = new USCoinCalculator();
        }

        if (change == 0)
        {
          return "No coin change needed.";
        }

        while (change > 0) //While we have change to work with:
        {
          if(change >= 25) //Case for: quarter
          {
            coinCount[0]++; //add a quarter to the count.
            change -= 25;
          }
          else if(change >= 10) //Case for: dime
          {
            coinCount[1]++; //add a dime to the count.
            change -= 10;
          }
          else if (change >= 5) //Case for: nickel
          {
            coinCount[2]++; //add a nickel to the count.
            change -= 5;
          }
          else if (change >= 1) //Case for: penny
          {
            coinCount[3]++; //add a penny to the count.
            change --;
          }
          else //change is 0 on 2nd+ input. Shouldn't occur.
          {
            return "Error.";
          }
        }

        return outputGeneration();
    }

    //Compiles our output String into a readable, grammatical format.
    public String outputGeneration()
    {
      //counts amount of different coins we have.
      for (int coinIndex = 0; coinIndex < coinCount.length; coinIndex++)
      {
        if (coinCount[coinIndex] != 0)
        {
          nonZeroCoinCount++;
        }
      }

      //Creating our (String) output:
      for (int coinIndex = 0; coinIndex < coinCount.length; coinIndex++)
      {
        if (coinCount[coinIndex] != 0) //if we have a value for quarter/ nickel/ ext.
        {
          output.append(coinCount[coinIndex] + " " + coinNames[coinIndex]); //write our coin + amount

          //Singular/ plural spell check:
          if (coinCount[coinIndex] > 1 && (coinNames[coinIndex]!= "penn"))
          {
            output.append("s"); //multiple quarter's'/dime's'
          }
          if (coinCount[coinIndex] == 1 && (coinNames[coinIndex]=="penn"))
          {
            output.append("y"); //singular penn'y'
          }
          if (coinCount[coinIndex] > 1 && (coinNames[coinIndex]== "penn"))
          {
            output.append("ies"); //multiple penn'ies'
          }

          //Adds commas, 'and, ', ext. for proper grammar.
          if (nonZeroCoinCount > 2) //and it is second to last coin listed...
          {
            output.append(", "); //we have (at least) 2 more coin types.
          }
          if (nonZeroCoinCount == 2)
          {
            output.append(", and "); //we have 1 more coin type.
          }
          if (nonZeroCoinCount == 1)
          {
            output.append("."); //we are at the last coin type.
          }
          nonZeroCoinCount--; //reduce remaining coin types, since we just listed one.
        }
      }
      return output.toString();
    }
}
