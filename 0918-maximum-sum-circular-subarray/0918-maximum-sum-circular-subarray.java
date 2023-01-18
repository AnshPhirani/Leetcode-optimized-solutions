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
        int maxMiddleSum = kadaneAlgo(nums, n);
        
        
        int[] maxSuffixSum = new int[n];
        maxSuffixSum[n-1] = Math.max(0, nums[n-1]);
        int suffixSum = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            suffixSum += nums[i];
            maxSuffixSum[i] = Math.max(maxSuffixSum[i+1], suffixSum);
        }
        
        int maxJoiningSum = Integer.MIN_VALUE;
        int prefixSum = nums[0];
        for(int i = 1; i < n; i++){
            maxJoiningSum = Math.max(maxJoiningSum, prefixSum + maxSuffixSum[i]);
            prefixSum += nums[i]; 
        }
        
        return Math.max(maxMiddleSum, maxJoiningSum);
        
    }
}