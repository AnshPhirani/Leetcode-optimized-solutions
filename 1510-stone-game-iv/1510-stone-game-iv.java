class Solution {
    
    public boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[n+1];
        dp[0] = false;
        
        outer:
        for(int i = 1; i <= n; i++){
            for(int k = 1; k <= Math.sqrt(i); k++){
                if(dp[i-k*k] == false){
                    dp[i] = true;
                    continue outer;
                }
            }
            dp[i] = false;
        }
        
        return dp[n];
    }
}