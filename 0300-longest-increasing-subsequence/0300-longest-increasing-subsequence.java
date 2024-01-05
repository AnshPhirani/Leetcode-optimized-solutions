class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int ans = 1;
        for(int i = 0; i < n; i++){
            lis[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && lis[j]+1 > lis[i]){
                    lis[i] = lis[j]+1;
                }
            }
            ans = Math.max(ans, lis[i]);
        }
        return ans;
    }
}