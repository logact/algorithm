package com.logact.array;

/**
 * @author: logact
 * @date: Created in 2019/8/16 20:00
 * @description:
 * easy
 * stock problem
 * get the value with the largest span in  the arrays
 */
public class BestTimeToBuyAndSellStock_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int minPoint=Integer.MAX_VALUE;
            int maxProfit=0;
            for(int i=0;i<prices.length;i++){
                if(prices[i]<minPoint)minPoint=prices[i];
                else {
                    if(maxProfit<prices[i]-minPoint)maxProfit=prices[i]-minPoint;
                }
            }
            return maxProfit;
        }
    }
}
