class Solution {
    
    private boolean isValidPairsPossible(int threshold, int p, int[] nums){
        // finding p pairs whose difference <= threshold
        int idx = 0;
        int count = 0;
        while(idx+1 < nums.length){
            int diff = nums[idx+1] - nums[idx];
            if(diff <= threshold){
                count++;
                idx += 2;
            }
            else{
                idx++;
            }
        }
        return count >= p;
    }
    
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int l = 0, h = nums[n-1]-nums[0];
        while(l < h){
            int mid = l+(h-l)/2;
            if(isValidPairsPossible(mid, p, nums)) h = mid;
            else l = mid+1;
        }
        return l;
    }
}