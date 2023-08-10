class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target) return true;
            
            if(nums[mid] > nums[l]){ // left side is sorted
                if(target >= nums[l] && target < nums[mid]){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else if(nums[mid] < nums[h]){
                if(target > nums[mid] && target <= nums[h]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            else{
                if(nums[l] == target) return true;
                l++;
            }
        }
        
        return false;
    }
}