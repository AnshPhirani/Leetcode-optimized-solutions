class Solution {

    Integer[][] memo;
    
    private int dfs(int idx, int time, int[] satisfaction){
        if(idx == satisfaction.length){
            return 0;
        }
        
        if(memo[idx][time] != null) return memo[idx][time];
        
        return memo[idx][time] = Math.max(dfs(idx+1, time,  satisfaction), time*satisfaction[idx] + dfs(idx+1, time+1, satisfaction));
        
    }
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        
        this.memo = new Integer[satisfaction.length][satisfaction.length+1];
        
        return dfs(0, 1, satisfaction);
    }
}