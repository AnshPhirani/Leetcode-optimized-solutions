class Solution {
    
    Integer[][] memo;
    
    private int dfs(int start, int turn, int[] piles){
        if(start >= piles.length) return 0;
        
        if(memo[start][turn] != null) return memo[start][turn];
        
        int curScore = (turn == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        int curSum = 0;
        for(int idx = start; idx < Math.min(start+3, piles.length); idx++){
            curSum += piles[idx];
            if(turn == 0){ // alice turn
                curScore = Math.max(curScore, curSum + dfs(idx+1, 1, piles));    
            }
            else{
                curScore = Math.min(curScore, -curSum + dfs(idx+1, 0, piles)); 
            }
        }
        
        return memo[start][turn] = curScore;
    }
    
    public String stoneGameIII(int[] piles) {
        this.memo = new Integer[piles.length][2];
        int aliceMinusBob = dfs(0, 0, piles);
        return aliceMinusBob == 0 ? "Tie" : aliceMinusBob > 0 ? "Alice" : "Bob"; 
    }
}