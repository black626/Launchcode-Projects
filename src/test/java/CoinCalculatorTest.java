import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: mpmenne (edits by Dylan Black)
 * Date: 6/18/14 (6/17/18)
 * Time: 3:28 AM (7:52PM)
 */
public class CoinCalculatorTest {

    @Test
    public void zeroChangeMeansYouGetZeroCoins() {
        USCoinCalculator USCoinCalculator = new USCoinCalculator();

        String coinMessage = USCoinCalculator.calculateChange(0);

        assertEquals("No coin change needed.", coinMessage);
    }

    @Test
    public void oneCentShouldGiveYouOnePenny() {
        USCoinCalculator USCoinCalculator = new USCoinCalculator();

        String coinMessage = USCoinCalculator.calculateChange(1);

        assertEquals("The shortest amount of change is 1 penny.", coinMessage);
    }

    @Test
    public void tenCentsShouldGiveYouOneDime() {
        USCoinCalculator USCoinCalculator = new USCoinCalculator();

        String coinMessage = USCoinCalculator.calculateChange(10);

        assertEquals("The shortest amount of change is 1 dime.", coinMessage);
    }

    @Test
    public void fiveCentsShouldGiveYouOneNickel() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange(5);

      assertEquals("The shortest amount of change is 1 nickel.", coinMessage);
    }

    @Test
    public void twentyFiveCentsShouldGiveYouOneQuarter() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange(25);

      assertEquals("The shortest amount of change is 1 quarter.", coinMessage);
    }

    @Test
    public void sixtySevenCentsShouldGiveYouOneQuarterOneDimeAndTwoPennies() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange(67);

      assertEquals("The shortest amount of change is 2 quarters, 1 dime, 1 nickel, and 2 pennies.", coinMessage);
    }
    /*
    //Euro Tests
    @Test
    public void oneEuroCentMeansYouGetAOneEuroCentCoin() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange("€0.01");

      assertEquals("1 1 euro cent coin", coinMessage);
    }

    @Test
    public void twoEuroCentsMeansYouGetATwoEuroCentCoin() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange("€0.02");

      assertEquals("1 2 euro cent coin", coinMessage);
    }

    @Test
    public void fiveEuroCentsMeansYouGetAFiveEuroCentCoin() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange("€0.05");

      assertEquals("1 5 euro cent coin", coinMessage);
    }

    @Test
    public void tenEuroCentsMeansYouGetATenEuroCentCoin() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange("€0.10");

      assertEquals("1 10 euro cent coin", coinMessage);
    }

    @Test
    public void twentyEuroCentsMeansYouGetATwentyEuroCentCoin() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange("€0.20");

      assertEquals("1 20 euro cent coin", coinMessage);
    }

    @Test
    public void fiftyEuroCentsMeansYouGetAFiftyEuroCentCoin() {
      USCoinCalculator USCoinCalculator = new USCoinCalculator();

      String coinMessage = USCoinCalculator.calculateChange("€0.50");

      assertEquals("1 50 euro cent coin", coinMessage);
    }
    */
}
