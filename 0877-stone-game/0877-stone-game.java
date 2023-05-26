class Solution {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int gap = 0; gap < n; gap++){
            for(int l = 0; l < n-gap; l++){
                int r = l+gap;
                if(gap == 0) {
                    dp[l][r] = piles[l];
                    continue;
                }
                int turn = (n-gap)%2;
                if(turn == 0){
                    dp[l][r] = Math.max(piles[l] + dp[l+1][r], piles[r] + dp[l][r-1]);
                }
                else{
                    dp[l][r] = Math.max(-piles[l] + dp[l+1][r], -piles[r] + dp[l][r-1]);
                }
            }
        }
        
        return dp[0][n-1] > 0;
        
    }
}