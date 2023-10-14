class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n-2; i++){
            max = Math.max(max, nums[i]);
            if(max > nums[i+2]) return false;
        }
        return true;
    }
}