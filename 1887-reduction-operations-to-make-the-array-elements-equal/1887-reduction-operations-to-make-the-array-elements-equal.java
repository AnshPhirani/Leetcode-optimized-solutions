class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int maxCount = 1;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] != nums[i+1]){
                ans += maxCount;
            }
            maxCount++;
        }
        return ans;
    }
}