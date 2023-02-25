class Solution {
    public int maxProfit(int[] prices) {
        int prevMin = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - prevMin);
            prevMin = Math.min(prevMin, prices[i]);
        }
        
        return maxProfit;
    }
}