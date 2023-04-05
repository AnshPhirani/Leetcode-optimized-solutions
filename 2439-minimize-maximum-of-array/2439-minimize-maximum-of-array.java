class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        long prefixSum = 0;
        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            res = Math.max(res, (prefixSum+i)/(i+1));
        }
        return (int)res;
    }
}