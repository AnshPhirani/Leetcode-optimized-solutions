class Solution {
    
    private int getSplitCount(int maxSubarraySum, int[] nums){
        int curSum = 0;
        int i = 0, count = 1;
        while(i < nums.length){
            if(nums[i] > maxSubarraySum) return Integer.MAX_VALUE;
            
            if(curSum + nums[i] <= maxSubarraySum){
                curSum += nums[i];
            }
            else{
                count++;
                curSum = nums[i];
            }
            i++;
        }
        
        return count;
    }
    
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = Arrays.stream(nums).sum();
        int res = -1;
        while(l <= h){
            int mid = l+(h-l)/2;
            int splitCount = getSplitCount(mid, nums);
            if(splitCount <= k){
                res = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
}