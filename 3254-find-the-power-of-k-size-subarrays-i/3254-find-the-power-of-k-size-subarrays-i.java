class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 || k == 1) return nums;
        
        int[] ans = new int[n-k+1];
        
        int consecCount = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1] + 1) consecCount++;
            else consecCount = 1;
            if(i >= k-1){
                ans[i-k+1] = consecCount >= k ? nums[i] : -1;
            }
        }
        
        return ans;
    }
}