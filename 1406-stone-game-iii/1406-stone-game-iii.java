class Solution {
    
    Integer[] memo;
    
    private int dfs(int start, int[] piles){
        if(start >= piles.length) return 0;
        
        if(memo[start] != null) return memo[start];
        
        int res = piles[start]-dfs(start+1, piles);
        if(start+1 < piles.length){
            res = Math.max(res, piles[start]+piles[start+1] - dfs(start+2, piles));
        }
        if(start+2 < piles.length){
            res = Math.max(res, piles[start]+piles[start+1]+piles[start+2] - dfs(start+3, piles));
        }
        
        return memo[start] = res;
    }
    
    public String stoneGameIII(int[] piles) {
        this.memo = new Integer[piles.length];
        int aliceMinusBob = dfs(0, piles);
        return aliceMinusBob == 0 ? "Tie" : aliceMinusBob > 0 ? "Alice" : "Bob"; 
    }
}