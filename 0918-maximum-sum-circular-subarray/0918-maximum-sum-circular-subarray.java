class Solution {
    
    private int kadaneAlgo(int[] nums, int n){
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i = 0; i < n; i++){
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
            if(curSum < 0) curSum = 0;
        }
        return maxSum;
    }
    
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        int maxSubarraySum = kadaneAlgo(nums, n);
        
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            totalSum += nums[i];
            nums[i] *= -1;
        }
        
        int minSubarraySum = kadaneAlgo(nums, n);
        
        return totalSum == -minSubarraySum ? maxSubarraySum : Math.max(maxSubarraySum, totalSum + minSubarraySum);
        
    }
}