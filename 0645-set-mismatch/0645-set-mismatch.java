class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int curSum = Arrays.stream(nums).sum();
        int expectedSum = n*(n+1)/2;
        
        int repeating = -1;
        for(int i = 0; i < n; i++){
            int correctIdx = Math.abs(nums[i])-1;
            if(nums[correctIdx] < 0) repeating = Math.abs(nums[i]);
            else nums[correctIdx] *= -1;
        }
        
        return new int[]{repeating, repeating+expectedSum-curSum};
        
        
    }
}