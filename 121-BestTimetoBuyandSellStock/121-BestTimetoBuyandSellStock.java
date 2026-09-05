// Last updated: 9/5/2026, 9:50:57 PM
1class Solution {
2
3    public int maxProfit(int[] prices) {
4        int minPrice = Integer.MAX_VALUE;
5        int maxProfit = 0;
6
7        for (int price : prices) {
8            if (price < minPrice) {
9                minPrice = price; // found a cheaper day to buy
10            } else {
11                maxProfit = Math.max(maxProfit, price - minPrice);
12            }
13        }
14
15        return maxProfit;
16    }
17}