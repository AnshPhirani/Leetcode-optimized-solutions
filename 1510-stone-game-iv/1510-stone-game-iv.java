class Solution {
    Boolean[] memo;
    
    private boolean dfs(int remaining){
        if(remaining == 0) return false;
        if(remaining == 1) return true;
        
        if(memo[remaining] != null) return memo[remaining];
        
        for(int k = 1; k <= Math.sqrt(remaining); k++){
            if(dfs(remaining-k*k) == false){
                return memo[remaining] = true; 
            }
        }
        
        return memo[remaining] = false;
    }
    
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