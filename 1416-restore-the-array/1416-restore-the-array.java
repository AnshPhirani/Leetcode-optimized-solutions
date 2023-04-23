class Solution {
    
    private final int MOD = (int)1e9+7;

    public int numberOfArrays(String str, int k) {
        int n = str.length();
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int start = 0; start < n; start++){
            long curNum = 0;
            if(str.charAt(start) == '0') continue;
            
            for(int end = start; end < n; end++){
                curNum = curNum*10 + str.charAt(end) - '0';
                if(curNum > k) break;
                dp[end+1] += dp[start];
                dp[end+1] %= MOD;
            }
        }
        
        return dp[n];
        
    }
}
