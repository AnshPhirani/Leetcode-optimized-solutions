class Solution {
    
    Integer[][] memo;
    
    private int helper(int idx, int[] nums, int target){
        if(target == 0) return 1;
        if(target < 0 || idx >= nums.length) return 0;
        
        if(memo[idx][target] != null) return memo[idx][target];
        
        return memo[idx][target] = helper(0, nums, target-nums[idx]) + helper(idx+1, nums, target);
    }
    
    public int combinationSum4(int[] nums, int target) {
        this.memo = new Integer[nums.length][target+1];
        return helper(0, nums, target);
    }
}