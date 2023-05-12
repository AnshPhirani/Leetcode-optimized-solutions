class Solution {
    
    Long[] memo;
    
    private long dfs(int idx, int[][] questions){
        if(idx >= questions.length) return 0;
        
        if(memo[idx] != null) return memo[idx];
        
        long solve = questions[idx][0] + dfs(idx+questions[idx][1]+1, questions);
        long skip = dfs(idx+1, questions);
        
        return memo[idx] = Math.max(solve, skip);
        
    }
    
    public long mostPoints(int[][] questions) {
        this.memo = new Long[questions.length];
        return dfs(0, questions);
    }
}