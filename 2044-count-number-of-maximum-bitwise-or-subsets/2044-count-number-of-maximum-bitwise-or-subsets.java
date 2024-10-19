class Solution {
    int maxOR;
    
    private int helper(int i, int OR, int[] nums){
        if(i == nums.length){
            return OR == maxOR ? 1 : 0;
        }
        
        if(OR == maxOR) return 1<<(nums.length-i);
        
        return helper(i+1, OR | nums[i], nums) + helper(i+1, OR, nums);
    }
    
    public int countMaxOrSubsets(int[] nums) {
        this.maxOR = 0;
        for(int num : nums) this.maxOR |= num;
        return helper(0, 0, nums);
    }
}