class Solution {
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        
        int[][] dp = new int[n+1][n+1];

        for(int i = n-1; i >= 0; i--){
            for(int time = i; time >= 0; time--){
                int include = (time+1)*satisfaction[i] + dp[i+1][time+1];
                int exclude = dp[i+1][time];
                dp[i][time] = Math.max(include, exclude); 
            }
        }
        
        return dp[0][0];
    }
}

