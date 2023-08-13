class Solution {
    
    Boolean[] memo;
    
    private boolean helper(int idx, int[] nums){
        if(idx == nums.length) return true;
        
        if(memo[idx] != null) return memo[idx];
        
        if(idx+1 < nums.length && nums[idx] == nums[idx+1] && helper(idx+2, nums)) return memo[idx] = true;
        if(idx+2 < nums.length && nums[idx] == nums[idx+1] && nums[idx] == nums[idx+2] && helper(idx+3, nums)) return memo[idx] = true;
        if(idx+2 < nums.length && nums[idx]+1 == nums[idx+1] && nums[idx+1]+1 == nums[idx+2] && helper(idx+3, nums)) return memo[idx] = true;
        
        return memo[idx] = false;
    }
    
    public boolean validPartition(int[] nums) {
        this.memo = new Boolean[nums.length];
        return helper(0, nums);    
    }
}