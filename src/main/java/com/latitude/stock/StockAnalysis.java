package com.latitude.stock;

public class StockAnalysis {
    public int getMaxProfit(int[] prices) {
        //check if price array is null or has 1 element, return 0
        if (prices == null || prices.length < 2) {
            return 0;
        }

        //initialize profile and least Stock Price.
        int maxProfit = 0;
        int leastPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            //if the current price is less than the least Price, set leastPrice to current Price
            if (prices[i] < leastPrice) {
                leastPrice = prices[i];
            } else if (prices[i] - leastPrice > maxProfit) {
                // if the difference between current price and leastPrice is greater than maxProfit thus far, update maxProfit
                maxProfit = prices[i] - leastPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        StockAnalysis stockAnalysis = new StockAnalysis();
        int[] stockPrices = {80, 2, 6, 3, 100};
        int maxProfit = stockAnalysis.getMaxProfit(stockPrices);
        System.out.println("the max possible profit is: " + maxProfit);
    }
}