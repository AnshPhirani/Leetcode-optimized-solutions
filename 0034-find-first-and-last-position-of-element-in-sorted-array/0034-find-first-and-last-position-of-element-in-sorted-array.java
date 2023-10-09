class Solution {
    
    private int findFirstPosition(int[] nums, int target){
        int l = 0, h = nums.length-1;
        int ans = -1;
        while(l <= h){
            int mid = (l+h)/2;
            if(nums[mid] == target) ans = mid;
            if(nums[mid] >= target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;   
    }
    
    private int findLastPosition(int[] nums, int target){
        int l = 0, h = nums.length-1;
        int ans = -1;
        while(l <= h){
            int mid = (l+h)/2;
            if(nums[mid] == target) ans = mid;
            if(nums[mid] <= target){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return ans;   
    }
    
    public int[] searchRange(int[] nums, int target) {
        int firstPos = findFirstPosition(nums, target);
        int lastPos = findLastPosition(nums, target);
        return new int[]{firstPos, lastPos};
    }
}