class Solution {
    Integer[][] memo;
    
    private int helper(int idx, int k, List<List<Integer>> piles){
        if(idx == piles.size()){
            return k == 0 ? 0 : Integer.MIN_VALUE;
        }
        
        if(memo[idx][k] != null) return memo[idx][k];
        
        int curAns = helper(idx+1, k, piles);
        
        List<Integer> pile = piles.get(idx);
        for(int i = 0; i < Math.min(pile.size(), k); i++){
            curAns = Math.max(curAns, pile.get(i) + helper(idx+1, k-(i+1), piles));
        }
        return memo[idx][k] = curAns;
    }
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for(List<Integer> pile : piles){
            for(int i = 1; i < pile.size(); i++){
                pile.set(i, pile.get(i)+pile.get(i-1));
            }
        }
        
        int[][] dp = new int[k+1][piles.size()+1];
        for(int i = 1; i <= k; i++){
            dp[i][0] = Integer.MIN_VALUE;
        }
        
        for(int curK = 1; curK <= k; curK++){
            for(int curIdx = 1; curIdx <= piles.size(); curIdx++){
                List<Integer> curPile = piles.get(curIdx-1);
                
                dp[curK][curIdx] = dp[curK][curIdx-1]; // not choosing from current pile
                for(int i = 0; i < Math.min(curK, curPile.size()); i++){
                    int temp = curPile.get(i) + dp[curK-(i+1)][curIdx-1];
                    dp[curK][curIdx] = Math.max(dp[curK][curIdx],  temp);
                }
            }
        }
        
        return dp[k][piles.size()];
    }
}