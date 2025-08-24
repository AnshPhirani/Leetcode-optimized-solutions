class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int s = 0; 
        int curSum = 0;
        int ans = 0;
        for(int e = 0; e < n; e++){
            curSum += nums[e];
            while(curSum < e-s){
                curSum -= nums[s++];
            }
            ans = Math.max(ans, e-s);
        }
        return ans;
    }
}

// [0,1,1,1,0,1,1,0,1]
// sum = 5
// s = 1 e = 7



