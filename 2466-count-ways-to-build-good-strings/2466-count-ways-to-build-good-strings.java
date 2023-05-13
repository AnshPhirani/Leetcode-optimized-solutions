class Solution {
    
    private static final int MOD = (int)1e9+7;

    
    public int countGoodStrings(int low, int high, int zero, int one) {

        int[] dp = new int[high+1];
        dp[0] = 1;
        
        int res = 0;
        
        for(int i = 1; i <= high; i++){
            if(i-zero >= 0) dp[i] = (dp[i] + dp[i-zero])%MOD;
            if(i-one >= 0) dp[i] = (dp[i] + dp[i-one])%MOD;
            
            if(i >= low) res = (res+dp[i])%MOD;
        }
        
        return res;
    }
}