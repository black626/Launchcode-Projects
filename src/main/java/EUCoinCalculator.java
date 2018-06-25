public class EUCoinCalculator implements CoinChange
{

  int[] coinCount; //Counts our list of coins so far.

  public EUCoinCalculator()
  {
    int[] coinCount = new int[5];
    //we count from largest to smallest coin in our array, so:
    //coinCount[0] are 50 euro cent coins.
    //coinCount[1] are 20 euro cent coins. (ext.)
  }

  public String calculateChange (int change)
  {
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
    String output = "The shortest amount of change is " + coinCount[0] + " (50) euro coins, " +
        coinCount[1] + " (20) euro coins, " + coinCount[2] + " (10) euro coins, " + coinCount[3] +
        " (5) euro coins, " + coinCount[4] + " (2) euro coins, and " + coinCount[5] + " (1) euro " +
        "coins.";
    return output;
  }
}
