class Solution {
    
    Integer[][] memo;
    
    private int dfs(int l, int r, int turn, int[] piles){
        if(l > r) return 0;
        
        if(memo[l][r] != null) return memo[l][r];
        
        if(turn == 0){
            int left = piles[l] + dfs(l+1, r, 1, piles);
            int right = piles[r] + dfs(l, r-1, 1, piles);
            return memo[l][r] = Math.max(left, right);
        }
        else{
            int left = -piles[l] + dfs(l+1, r, 0, piles);
            int right = -piles[r] + dfs(l, r-1, 0, piles);
            return memo[l][r] = Math.min(left, right);
        }
    }
    public boolean stoneGame(int[] piles) {
        memo = new Integer[piles.length][piles.length];
        return dfs(0, piles.length-1, 0, piles) > 0;
    }
}