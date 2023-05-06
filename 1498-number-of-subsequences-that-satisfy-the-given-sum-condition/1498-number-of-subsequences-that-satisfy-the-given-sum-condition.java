class Solution {
    private static final int MOD = (int)1e9 + 7;
    
    private int lowerBound(int[] nums, int target){
        int l = 0, r = nums.length-1;
        int res = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] <= target){
                res = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        
        return res;
    }
    
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int[] power = new int[n];
        power[0] = 1;
        for(int i = 1; i < n; i++){
            power[i] = (2*power[i-1])%MOD;
        }
            
        int res = 0;
        for(int left = 0; left < n; left++){
            int right = lowerBound(nums, target-nums[left]);
            if(right < left) break;

            res += power[right-left];
            res %= MOD;
        }
        
        return res%MOD;
    }
}