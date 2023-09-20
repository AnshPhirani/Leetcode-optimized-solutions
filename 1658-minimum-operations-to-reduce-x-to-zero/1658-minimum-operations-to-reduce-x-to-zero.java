class Solution {
    public int minOperations(int[] nums, int x) {
        int n  = nums.length;
        int sum = Arrays.stream(nums).sum();
        int targetSum = sum-x;
        
        if(targetSum < 0) return -1;
        if(targetSum == 0) return n;
        
        // sliding window
        int s = 0, e = 0;
        int curSum = 0, maxLen = -1;
        while(e < n){
            curSum += nums[e];
            while(curSum > targetSum){
                curSum -= nums[s++];
            }
            if(curSum == targetSum){
                maxLen = Math.max(maxLen, e-s+1);
            }
            e++;
        }
        
        return maxLen == -1 ? -1 : n-maxLen;
    }
}