class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int s = 0;
        int curSum = 0;
        for(int e = 0; e < nums.length; e++){
            curSum += nums[e];
            while(curSum >= target){
                ans = Math.min(ans, e-s+1);
                curSum -= nums[s++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}