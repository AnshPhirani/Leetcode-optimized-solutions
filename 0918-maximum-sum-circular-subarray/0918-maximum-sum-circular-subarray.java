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
        
        int totalSum = 0;
        
        int maxSum = Integer.MIN_VALUE;
        int curMax = 0;
        int minSum = Integer.MAX_VALUE;
        int curMin = 0;
        
        for(int i = 0; i < n; i++){
            curMax += nums[i];
            maxSum = Math.max(maxSum, curMax);
            if(curMax < 0) curMax = 0;
            
            curMin += nums[i];
            minSum = Math.min(minSum, curMin);
            if(curMin > 0) curMin = 0;
            
            totalSum += nums[i];
        }
        
        return minSum == totalSum ? maxSum : Math.max(maxSum, totalSum - minSum);
        
    }
}