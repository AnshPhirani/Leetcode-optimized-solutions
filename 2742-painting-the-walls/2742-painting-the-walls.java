class Solution {
    
    int[] cost, time;
    int n;
    Integer[][] memo;
    
    private int helper(int idx, int totalTime){
        if(totalTime == n) return 0;
        if(idx == n) return 999999999;
        
        if(memo[idx][totalTime] != null) return memo[idx][totalTime];
        
        int paid = helper(idx+1, Math.min(totalTime+1+time[idx], n)) + cost[idx];
        int free = helper(idx+1, totalTime);
        return memo[idx][totalTime] = Math.min(paid, free);
    }
     
    public int paintWalls(int[] cost, int[] time) {
        this.cost = cost;
        this.time = time;
        this.n = cost.length;
        this.memo = new Integer[n][n];
        
        return helper(0, 0);
    }
}