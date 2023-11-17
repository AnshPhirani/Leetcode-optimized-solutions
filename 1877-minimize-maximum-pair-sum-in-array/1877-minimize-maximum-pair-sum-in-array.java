class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = Integer.MIN_VALUE;
        for(int idx = 0; idx < nums.length/2; idx++){
            maxSum = Math.max(maxSum, nums[idx] + nums[nums.length-idx-1]);
        }
        return maxSum;
    }
}