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


    //Euro Tests
    @Test
    public void oneEuroCentMeansYouGetAOneEuroCentCoin() {
      EUCoinCalculator EUCoinCalculator = new EUCoinCalculator();

      String coinMessage = EUCoinCalculator.calculateChange(1);

      assertEquals("The shortest amount of change is 1 (1)-cent Euro coin.", coinMessage);
    }

    @Test
    public void twoEuroCentsMeansYouGetATwoEuroCentCoin() {
      EUCoinCalculator EUCoinCalculator = new EUCoinCalculator();

      String coinMessage = EUCoinCalculator.calculateChange(2);

      assertEquals("The shortest amount of change is 1 (2)-cent Euro coin.", coinMessage);
    }

    @Test
    public void fiveEuroCentsMeansYouGetAFiveEuroCentCoin() {
      EUCoinCalculator EUCoinCalculator = new EUCoinCalculator();

      String coinMessage = EUCoinCalculator.calculateChange(5);

      assertEquals("The shortest amount of change is 1 (5)-cent Euro coin.", coinMessage);
    }

    @Test
    public void tenEuroCentsMeansYouGetATenEuroCentCoin() {
      EUCoinCalculator EUCoinCalculator = new EUCoinCalculator();

      String coinMessage = EUCoinCalculator.calculateChange(10);

      assertEquals("The shortest amount of change is 1 (10)-cent Euro coin.", coinMessage);
    }

    @Test
    public void twentyEuroCentsMeansYouGetATwentyEuroCentCoin() {
      EUCoinCalculator EUCoinCalculator = new EUCoinCalculator();

      String coinMessage = EUCoinCalculator.calculateChange(20);

      assertEquals("The shortest amount of change is 1 (20)-cent Euro coin.", coinMessage);
    }

    @Test
    public void fiftyEuroCentsMeansYouGetAFiftyEuroCentCoin() {
      EUCoinCalculator EUCoinCalculator = new EUCoinCalculator();

      String coinMessage = EUCoinCalculator.calculateChange(50);

      assertEquals("The shortest amount of change is 1 (50)-cent Euro coin.", coinMessage);
    }
}
