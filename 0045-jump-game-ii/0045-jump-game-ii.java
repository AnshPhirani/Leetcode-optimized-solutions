class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        
        int count = 0, low = 0, high = 0;
        while(high < n-1){
            int maxJump = 0;
            for(int i = low; i <= high; i++){
                maxJump = Math.max(maxJump, nums[i]+i);
            }
            low = high+1;
            high = maxJump;
            count++;
        }
        
        return count;
    }
}