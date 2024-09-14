class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int num : nums) max = Math.max(max, num);
        
        int ans = 0;
        int consec = 0;
        for(int num : nums){
            if(num == max) consec++;
            else consec = 0;
            ans = Math.max(ans, consec);
        }
        
        return ans;
        
    } 
}