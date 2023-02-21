class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid+1 < n && nums[mid] == nums[mid+1]){
                mid += 1;
            }
            if(mid == 0 || nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            
            if((mid-1)%2 != 0) high = mid-2;
            else low = mid+1;
        }
        
        return -1; // never reached
    }
}