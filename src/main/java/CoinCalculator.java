/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:06 AM
 */
public class CoinCalculator {


    public String calculateChange(String amountOfChange) {
        Integer change = Integer.parseInt(amountOfChange.substring(amountOfChange.length() - 2));
        if(change > 9) {
            return "1 dime";
        } else if (change > 0) {
            return "1 penny";
        } else {
            return "No coins returned";
        }
    }
}
