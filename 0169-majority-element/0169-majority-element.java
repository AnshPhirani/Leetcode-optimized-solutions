class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 0;
        for(int num : nums){
            if(ele == num) count++;
            else count--;
            if(count == 0) {
                ele = num;
                count = 1;
            }
        }
        
        return ele;
        
    }
}