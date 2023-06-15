class Solution {
    private static final int MOD = (int)1e9 + 7;
    Integer[][] memo;
    
    private int helper(int idx, int steps, int arrLen){
        if(steps == 0) return idx == 0 ? 1 : 0;
        
        if(memo[idx][steps] != null) return memo[idx][steps];
            
        int count = 0;
        // Stay at same postion
        count = (count + helper(idx, steps-1, arrLen))%MOD;
        
        // Move to left
        if(idx-1 >= 0)
            count = (count + helper(idx-1, steps-1, arrLen))%MOD;
        
        // Move to right
        if(idx+1 < arrLen)
            count = (count + helper(idx+1, steps-1, arrLen))%MOD;
        
        return memo[idx][steps] = count%MOD;
    }
    
    public int numWays(int steps, int arrLen) {
        this.memo = new Integer[steps+1][steps+1];
        return helper(0, steps, arrLen)%MOD;
    }
}