Latitude Financial Stock Analysis
==========

StockAnalysis Class - getMaxProfit
-----
* This method takes in an array of stock prices and returns the best profit could have been made from 1 purchase and 1 sale of 1 stock.
* It returns 0 (default) if the user could not make any profit
* Program runs with a time complexity of O(n) with no extra space
* To make the program efficient and performant, buy and sell price with times have not recorded in the program since the goal of the program is to return maximum Profit. 
   This, however can be easily tweaked to persist and return more values as need be.

Testing:
-----
There are a couple of ways to test the program:
* com.latitude.stock.StockAnalysis has a main method that initializes the class and performs getMaxProfit
* com.latitude.stock.StockAnalysisTest in src/test/java/ has a bunch of tests that test boundary conditions and a repeating test that tests against a large dataset.
 


   


