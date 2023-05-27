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
        this.memo = new Boolean[n+1];
        return dfs(n);
    }
}