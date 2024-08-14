class Solution {
    
    private int countSmallestDistancePair(int[] nums, int distance){
        int count = 0;
        int left = 0, right = 1;
        int curDist = 0;
        while(right < nums.length){
            curDist = nums[right] - nums[left];
            if(curDist > distance) left++;
            else{
                count += right-left;
                right++;
            }
            if(left == right) right++;
        }
        
        return count;
    }
    
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums[nums.length-1] - nums[0];
        
        while(left < right){
            int mid = (left + right)/2;
            int count = countSmallestDistancePair(nums, mid);

            if(count < k){
                left = mid+1;
            }
            else if(count >= k){
                right = mid;
            }
        }
        
        return left;
    }
}