class Solution {
    
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length+1];
        dp[0] = true;
        
        for(int i = 0; i < nums.length; i++){    
            if(i-1 >= 0 && nums[i] == nums[i-1]) dp[i+1] |= dp[i-1];
            if(i-2 >= 0 && nums[i] == nums[i-1] && nums[i] == nums[i-2]) dp[i+1] |= dp[i-2];
            if(i-2 >= 0 && nums[i] == nums[i-1]+1 && nums[i-1] == nums[i-2]+1) dp[i+1] |= dp[i-2];
        }
        return dp[nums.length];
    }
}