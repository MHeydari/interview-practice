package chalenges;

/*
After recently joining Instacart's beta testing developer group, you decide to experiment with their new API.
You know that the API returns item-specific display-ready strings like 10.0% higher than in-store or 5.0% lower
than in-store that inform users when the price of an item is different from the one in-store.
But you want to extend this functionality by giving people a better sense of how much more they will be paying for
their entire shopping cart.
Your app lets a user decide the total amount x they are willing to pay via Instacart over in-store prices.
This you call their price sensitivity.
Your job is to determine whether a given customer will be willing to pay for the given items in their
cart based on their stated price sensitivity

Example:
    For
    prices = [110, 95, 70],
    notes = ["10.0% higher than in-store",
             "5.0% lower than in-store",
             "Same as in-store"]
    and x = 5, the output should be
    isAdmissibleOverpayment(prices, notes, x) = true.
    In-store prices of the first and the second items are 100, and the price of the third item is 70, which means the customer is overpaying 10 - 5 + 0 = 5, which they are willing to do based on their price sensitivity.

    For
    prices = [48, 165],
    notes = ["20.00% lower than in-store",
             "10.00% higher than in-store"]
    and x = 2, the output should be
    isAdmissibleOverpayment(prices, notes, x) = false.
    The in-store price of the first item is 60, and the second item is 150.
    The overpayment equals 15 - 12 = 3, which is too much for the customer to be willing to pay.
 */
public class isAdmissibleOverpayment {
    float getValue(String s){return Float.parseFloat(s.substring(0, s.indexOf("%")));}
    float getOriginalPrice(float currentPrice , float percent){
        if (percent != 0) return  currentPrice / (1 + percent/100);
        return 0;
    };
    double getOverPayment(float currentPrice , float percent){
        double orgValue = getOriginalPrice(currentPrice , percent);
        System.out.println("ovp of " + currentPrice + " in percent " + percent +" is : " + orgValue);
        System.out.println("overpayment = " + (currentPrice - orgValue));
        return currentPrice - orgValue;
    };
    boolean isAdmissibleOverpayment(double[] prices, String[] notes, double x) {
        double[] percent = new double[prices.length];
        int i = 0;
        for (String s: notes){
            if(s.contains("higher")) percent[i++] = getValue(s);
            else if(s.contains("lower")) percent[i++] = -1 * getValue(s);
            else percent[i++] = 0;
        }
        double totalOverPayment = 0;
        for(int j = 0; j< prices.length; j++){
            if( percent[j] != 0){
                totalOverPayment = totalOverPayment  + getOverPayment((float)(prices[j]) ,(float) percent[j]);
            }
        }
        System.out.println("total overpay: " + totalOverPayment + " X = " + x);
        return x >= totalOverPayment;
    }
}
