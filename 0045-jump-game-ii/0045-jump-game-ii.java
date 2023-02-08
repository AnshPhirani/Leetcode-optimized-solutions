class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i < n; i++){
             for(int j = i+1; j < Math.min(n, i + nums[i]+1); j++){
                 dp[j] = Math.min(dp[j], 1 + dp[i]);
             }
        }
        
        return dp[n-1];
        
    }
}