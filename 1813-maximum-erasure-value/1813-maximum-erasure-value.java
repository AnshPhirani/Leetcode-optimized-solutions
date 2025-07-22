class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int curSum = 0, maxSum = 0;
        int start = 0;
        for(int end = 0; end < nums.length; end++){
            int curVal = nums[end];
            while(set.contains(curVal)){
                curSum -= nums[start];
                set.remove(nums[start++]);
            }
            set.add(curVal);
            curSum += curVal;
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}