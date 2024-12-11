class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBeauty = 0;
        int left = 0, right = 0;
        while(right < nums.length){
            while(nums[right]-nums[left] > 2*k){
                left++;
            }
            maxBeauty = Math.max(maxBeauty, right-left+1);
            right++;
        }
        return maxBeauty;
    }
}