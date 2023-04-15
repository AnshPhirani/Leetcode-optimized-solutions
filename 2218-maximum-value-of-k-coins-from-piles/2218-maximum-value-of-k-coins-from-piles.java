class Solution {
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n+1][k+1];

        for(int idx = 1; idx <= n; idx++){
            for(int coins = 0; coins <= k; coins++){
                // skip choosing from current pile
                dp[idx][coins] = Math.max(dp[idx][coins], dp[idx-1][coins]);
                
                // choosing j coins from current pile
                List<Integer> curPile = piles.get(idx-1);
                int size = curPile.size();
                int curSum = 0;
                for(int j = 0; j < Math.min(size, coins); j++){
                    curSum += curPile.get(j);
                    dp[idx][coins] = Math.max(dp[idx][coins], curSum + dp[idx-1][coins-(j+1)]);
                }
                
            }
        }
        
        return dp[n][k];
        
    }
}