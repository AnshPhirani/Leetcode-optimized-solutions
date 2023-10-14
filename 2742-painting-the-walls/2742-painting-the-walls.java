class Solution {
    Integer[][] memo;
    
    private int helper(int idx, int timeCollapsed, int n, int[] cost, int[] time){
        if(timeCollapsed == n) return 0;
        if(idx == n) return 999999999;
        
        if(memo[idx][timeCollapsed] != null) return memo[idx][timeCollapsed];
        
        // paint current wall by paid painter
        int paint = cost[idx] + helper(idx+1, Math.min(timeCollapsed+1+time[idx], n), n, cost, time);
        
        // skip current wall for free painter
        int skip = helper(idx+1, timeCollapsed, n, cost, time);
        
        return memo[idx][timeCollapsed] = Math.min(paint, skip);
    }
    
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        memo = new Integer[n][n];
        return helper(0, 0, n, cost, time);        
    }
}