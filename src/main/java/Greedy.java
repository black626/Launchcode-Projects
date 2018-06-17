/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:05 AM
 */
public class Greedy {


    public static void main(String[] varArgs) {
        if (varArgs.length > 1) {
            CoinCalculator coinCalculator = new CoinCalculator();
            coinCalculator.calculateChange(varArgs[0]);
        }
        throw new IllegalArgumentException("No value given");
    }

}
