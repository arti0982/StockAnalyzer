package com.latitude.stock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockAnalysisTest {
    private static StockAnalysis stockAnalysis = null;

    @BeforeAll
    static void setUp() throws Exception {
        stockAnalysis = new StockAnalysis();
    }

    @Test
    public void testNull() {
        assertEquals(0, stockAnalysis.getMaxProfit(null));
    }

    @Test
    public void testSingleStock() {
        int[] stockPrices = {10};
        assertEquals(0, stockAnalysis.getMaxProfit(stockPrices));
    }

    @Test
    public void testDecreasingStocks() {
        int[] stockPrices = {929, 38, 7, 4, 3, 1};
        assertEquals(0, stockAnalysis.getMaxProfit(stockPrices));
    }

    @Test
    public void testGivenTestCase() {
        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        assertEquals(6, stockAnalysis.getMaxProfit(stockPrices));
    }

    //An all encompassing test with million stock prices, run in repeat mode - 20 times
    //This generates min and max stock prices and places them in random indexes in the array.
    // It then fills the remainder of the array with random values between min and max stock prices
    // Finally the assert ensures that the maxProfit will always be max - min values
    @RepeatedTest(20)
    public void testLargeArrayOfRandomStocks() {
        int totalRecords = 1000000;
        int[] stockPrices = new int[totalRecords];

        int minIndex = getRandomNumberinRange(0, totalRecords - 2); // random array index from 0 to 999,999
        int maxIndex = getRandomNumberinRange(minIndex + 1, totalRecords - 1); //random array index greater than minIndex

        int minStockPrice = getRandomNumberinRange(1, totalRecords / 2);//setting minimum stock price a number from 1 to 500,000
        int maxStockPrice = getRandomNumberinRange(minStockPrice + 2, totalRecords - 1);//setting max stock price, from minStockPrice+2 to 999,999

        stockPrices[minIndex] = minStockPrice;
        stockPrices[maxIndex] = maxStockPrice;

        System.out.println("minIndex:" + minIndex + " maxIndex:" + maxIndex + " minStockPrice:" + minStockPrice + " maxStockPrice:" + maxStockPrice);

        for (int i = 0; i < 1000000; i++) {
            if (i != minIndex && i != maxIndex) {
                stockPrices[i] = getRandomNumberinRange(minStockPrice + 1, maxStockPrice - 1);//set stock price between min and max
            }
        }
        assertEquals(maxStockPrice - minStockPrice, stockAnalysis.getMaxProfit(stockPrices));//calculated maxProfit would always be max-min
    }

    public static int getRandomNumberinRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    @AfterAll
    static void tearDown() throws Exception {
        stockAnalysis = null;
    }
}
