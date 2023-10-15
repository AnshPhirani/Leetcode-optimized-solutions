class Solution {

    private int helper(int idx, int steps, int n, Integer[][] memo){        
        if(idx == 0 && steps == 0) return 1;
        if(idx < 0 || idx >= n || steps <= 0 || idx > steps) return 0;
        
        if(memo[idx][steps] != null) return memo[idx][steps]; 
        
        int stay =  helper(idx, steps-1, n, memo);
        int left =  helper(idx-1, steps-1, n, memo);
        int right =  helper(idx+1, steps-1, n, memo);
        
        return memo[idx][steps] = ((stay + left)%1000000007 + right)%1000000007;
        
    }
    
    public int numWays(int steps, int arrLen) {
        return helper(0, steps, arrLen, new Integer[steps/2+1][steps+1]);
    }
}