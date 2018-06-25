public class EUCoinCalculator implements CoinChange
{

  int[] coinCount; //Counts our list of coins so far.
  String[] coinNames; //List of our coins.
  StringBuilder output;
  int nonZeroCoinCount = 0; //counts our non-zero coins, used for grammatical output.

  private static EUCoinCalculator euCC;

  public EUCoinCalculator()
  {
    coinCount = new int[6];
    //we count from largest to smallest coin in our array, so:
    //coinCount[0] are 50-Euro coins.
    //coinCount[1] are 20-Euro coins. (ext.)
    //list of our coins:
    coinNames = new String[6];
    coinNames[0] = "(50)-cent Euro coin";
    coinNames[1] = "(20)-cent Euro coin";
    coinNames[2] = "(10)-cent Euro coin";
    coinNames[3] = "(5)-cent Euro coin";
    coinNames[4] = "(2)-cent Euro coin";
    coinNames[5] = "(1)-cent Euro coin";
    //Default leader for output:
    output = new StringBuilder("The shortest amount of change is ");
  }

  //Getter method.
  public static EUCoinCalculator getInstance()
  {
    if (euCC == null)
    {
      euCC = new EUCoinCalculator();
    }
    return euCC;
  }

  public String calculateChange (int change)
  {
    if (euCC == null)
    {
      euCC = new EUCoinCalculator();
    }


    while (change > 0)
    {
      if (change >= 50)
      {
        coinCount[0]++; //add a 50 euro coin to the count.
        change -= 50;
      }
      else if (change >= 20)
      {
        coinCount[1]++; //add a 20 euro coin to the count.
        change -= 20;
      }
      else if (change >= 10)
      {
        coinCount[2]++; //add a 10 euro coin to the count.
        change -= 10;
      }
      else if (change >= 5)
      {
        coinCount[3]++; //add a 5 euro coin to the count.
        change -= 5;
      }
      else if (change >= 2)
      {
        coinCount[4]++; //add a 2 euro coin to the count.
        change -= 2;
      }
      else if (change >= 1)
      {
        coinCount[5]++; //add a 1 euro coin to the count.
        change -= 1;
      }
      else //Nothing left to return.
      {
        return "No coins returned";
      }
    }

    //counts amount of different coins we have.
    for (int count = 0; count < coinCount.length; count++)
    {
      if (coinCount[count] != 0)
      {
        nonZeroCoinCount++;
      }
    }

    //Creating our (String) output:
    for (int count = 0; count < coinCount.length; count++)
    {
      if (coinCount[count] != 0) //if we have a value for 50/20-Euro coin, ext.
      {
        output.append(coinCount[count] + " " + coinNames[count]); //write our coin + amount

        //Singular/ plural spell check:
        if (coinCount[count] > 1)
        {
          output.append("s");
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
