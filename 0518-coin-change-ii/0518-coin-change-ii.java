class Solution {
    
    Integer[][] memo;
    
    private int helper(int idx, int curAmount, int targetAmount, int[] coins){
        if(curAmount == targetAmount) return 1;
        if(idx == coins.length || curAmount > targetAmount) return 0;
        
        if(memo[idx][curAmount] != null) return memo[idx][curAmount];
        
        return memo[idx][curAmount] = helper(idx, curAmount+coins[idx], targetAmount, coins) + helper(idx+1, curAmount, targetAmount, coins);        
        
    }
    
    public int change(int amount, int[] coins) {
        this.memo = new Integer[coins.length][amount];
        
        return helper(0, 0, amount, coins);
    }
}