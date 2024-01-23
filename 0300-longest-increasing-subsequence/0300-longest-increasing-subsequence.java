class Solution {
    
    private int bSearch(int[] arr, int target){
        int l = 0, h = arr.length-1;
        int ansIdx = 0;
        while(l <= h){
            int mid = (l+h)/2;
            if(arr[mid] < target){
                ansIdx = mid;
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return ansIdx;
    }
    
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        
        int LIS = 0;
        
        for(int i = 1; i <= n; i++){
            int prev = bSearch(dp, nums[i-1]);
            dp[prev+1] = nums[i-1];
            LIS = Math.max(LIS, prev+1);
        }
        
        return LIS;
    }
}