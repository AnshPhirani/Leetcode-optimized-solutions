class Solution {
    public int longestSubarray(int[] nums) {
        boolean deletedOne = false;
        int s = 0, e = 0;
        int ans = 0;
        while(e < nums.length){
            int num = nums[e];
            while(num == 0 && deletedOne){
                if(nums[s] == 0) deletedOne = false;
                s++;
            }
            if(num == 0) deletedOne = true;
            e++;
            ans = Math.max(ans, e-s-1);
        }
        
        return ans;
    }
}