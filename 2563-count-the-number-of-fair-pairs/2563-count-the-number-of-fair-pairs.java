class Solution {
    
    private int binarySearch(int target, int s, int e, int[] nums){
        while(s <= e){
            int mid = (s+e)/2;
            if(nums[mid] < target) s = mid+1;
            else e = mid-1;
        }
        return s;
    }
    
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        if(n == 1) return 0;
        
        Arrays.sort(nums);
        long count = 0;
        for(int i = 0; i < n-1; i++){
            int left = binarySearch(lower-nums[i], i+1, n-1, nums);
            int right = binarySearch(upper-nums[i]+1, i+1, n-1, nums);
            count += right-left;
        }
        
        return count;
    }
}

// [0,1,4,4,5,7]

// x + y = lower
// y = lower-x;