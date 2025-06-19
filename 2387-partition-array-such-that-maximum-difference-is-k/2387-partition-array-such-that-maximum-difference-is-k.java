class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int start = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i]-start > k){
                count++;
                start = nums[i];
            }
        }
        return count;
    }
}