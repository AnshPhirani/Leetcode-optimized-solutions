class Solution {
    
    public boolean canSortArray(int[] nums) {
        int curMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length;){
            int newMax = Integer.MIN_VALUE;
            int newMin = Integer.MAX_VALUE;
            int curBitCount = Integer.bitCount(nums[i]);
            while(i < nums.length && Integer.bitCount(nums[i]) == curBitCount){
                newMax = Math.max(newMax, nums[i]);
                newMin = Math.min(newMin, nums[i]);
                i++;
            }
            if(newMin < curMax) return false;
            curMax = newMax;
        }
        
        return true;  
    }
}