class Solution {
    
    Integer[][] memo;
    
    // state 1 -> acquired 0 -> not acquired
    private int helper(int idx, int state, int[] prices, int fee){
        if(idx == prices.length){
                return 0;
        }
        
        if(memo[idx][state] != null) return memo[idx][state];
        
        if(state == 0){
            int acquireNow = helper(idx+1, 1, prices, fee) - prices[idx] -fee;
            int skip = helper(idx+1, 0, prices, fee);
            return memo[idx][state] = Math.max(acquireNow, skip);
        }
        else{
            int sellNow = prices[idx] + helper(idx+1, 0, prices, fee);
            int skip = helper(idx+1, 1, prices, fee);
            return memo[idx][state] = Math.max(sellNow, skip);
        }
    }
    
    public int maxProfit(int[] prices, int fee) {
        this.memo = new Integer[prices.length][2];
        return helper(0, 0, prices, fee);
    }
}