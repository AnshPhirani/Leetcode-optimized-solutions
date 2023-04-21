class Solution {
    final static int MOD = (int)1e9+7;
    int[] group, profit;
    int n, minProfit;
    
    Integer[][][] memo;
    
    private int dfs(int idx, int curMembers, int curProfit){
        if(idx == group.length){
            if(curMembers <= n && curProfit >= minProfit) return 1;
            return 0;
        }
        if(curMembers > n) return 0;
        
        if(memo[idx][curMembers][curProfit] != null) return memo[idx][curMembers][curProfit];
        
        // including the current crime
        int include = dfs(idx+1, curMembers+group[idx], Math.min(minProfit, curProfit+profit[idx]));
        
        // not including the current crime
        int notInclude = dfs(idx+1, curMembers, curProfit);
         
        return memo[idx][curMembers][curProfit] = (include+notInclude)%MOD; 
        
    }
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.group = group;
        this.profit = profit;
        this.n = n;
        this.minProfit = minProfit;
        this.memo = new Integer[101][101][101];
        
        return dfs(0, 0, 0);
        
    }
}