class Solution {
    
    Integer[][][] memo;
    
    private int dfs(int start, int turn, int m, int[] piles){
        if(start >= piles.length) return 0;
        
        if(memo[start][m][turn] != null) return memo[start][m][turn];
        
        int curScore = (turn == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        int curSum = 0;
        for(int idx = start; idx < Math.min(start+2*m, piles.length); idx++){
            curSum += piles[idx];
            if(turn == 0){ // alice turn
                curScore = Math.max(curScore, curSum + dfs(idx+1, 1, Math.max(m, idx-start+1), piles));    
            }
            else{
                curScore = Math.min(curScore,  dfs(idx+1, 0, Math.max(m, idx-start+1), piles)); 
            }
        }
        
        return memo[start][m][turn] = curScore;
    }
    
    public int stoneGameII(int[] piles) {
        this.memo = new Integer[piles.length][piles.length+1][2];
        return dfs(0, 0, 1, piles);
    }
}