class Solution {
    public String stoneGameIII(int[] piles) {
        int n  = piles.length;
        int[] dp = new int[n+1];
        for(int i = n-1; i >= 0; i--){
            dp[i] = piles[i]-dp[i+1];
            if(i+1 < n){
                dp[i] = Math.max(dp[i], piles[i]+piles[i+1] - dp[i+2]);
            }
            if(i+2 < n){
                dp[i] = Math.max(dp[i], piles[i]+piles[i+1]+piles[i+2] - dp[i+3]);
            }
        }
        if(dp[0] == 0) return "Tie";
        return dp[0] > 0 ? "Alice" : "Bob"; 
    }
}