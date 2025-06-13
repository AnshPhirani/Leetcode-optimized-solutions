class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] diff = new int[n-1];
        for(int i = 0; i < n-1; i++){
            diff[i] = nums[i+1]-nums[i];
        }
        Arrays.sort(diff);
        
        
        int ans = 0;
        for(int i = 0; i < diff.length && p-- > 0; i+=2){
            ans = Math.max(ans, diff[i]);
        }
        return ans;
    }
}