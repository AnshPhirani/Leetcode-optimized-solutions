class Solution {
    
    private boolean isSplitPossible(int maxSubarraySum, int k, int[] nums){
        int curSum = 0;
        int i = 0, count = 1;
        while(i < nums.length){
            if(nums[i] > maxSubarraySum) return false;
            
            if(curSum + nums[i] <= maxSubarraySum){
                curSum += nums[i];
            }
            else{
                count++;
                curSum = nums[i];
            }
            i++;
        }
        
        return count <= k;
        
    }
    
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = Arrays.stream(nums).sum();
        int res = -1;
        while(l <= h){
            int mid = l+(h-l)/2;
            if(isSplitPossible(mid, k, nums)){
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