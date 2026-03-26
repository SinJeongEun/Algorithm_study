package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.slidingWindow;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Stock {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;

        int left = 0;
        int right = 1;
        int maxValue = 0;

        while(right < prices.length) {
            if(prices[right] - prices[left] < 0) {
                left = right;
                right++;
                continue;
            }

            maxValue = Math.max(maxValue, prices[right] - prices[left]);
            right++;
        }

        return maxValue;
    }

}
