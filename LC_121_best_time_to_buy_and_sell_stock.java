public class LC_121_best_time_to_buy_and_sell_stock {
    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0], maxProfit = 0, currentProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // we are updating buy price when getting lesser one
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }
            // if buy price is updated the computations will not
            // take place as the buying and selling days cannot
            // be the same day.
            else {
                currentProfit = prices[i] - buyPrice;
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 2, 4, 5, 1, 3, 6, 4 };
        int profit = maxProfit(prices);
        System.out.println("Maximum Profit: " + profit);
    }
}
