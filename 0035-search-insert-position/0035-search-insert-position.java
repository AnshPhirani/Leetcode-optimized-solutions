class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if(idx < 0) return Math.abs(idx)-1;
        else return idx;
    }
}