class LC_122_best_time_to_buy_and_sell_stock_ii {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int dailyProfit = Math.max(0, prices[i] - prices[i - 1]);
            maxProfit += dailyProfit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 4, 5 };
        int profit = maxProfit(prices);
        System.out.println("Maximum Profit: " + profit);
    }
}