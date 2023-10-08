class Solution {
    
    Integer[][] memo;
    
    private int helper(int i, int j, int[] nums1, int[] nums2){
        if(i >= nums1.length || j >= nums2.length) return 0;
 
        if(memo[i][j] != null) return memo[i][j];
        
        
        int ans = Integer.MIN_VALUE;
        // map current numbers
        ans = Math.max(ans, nums1[i]*nums2[j] + helper(i+1, j+1, nums1, nums2));
        
        // skip from nums1
        ans = Math.max(ans, helper(i+1, j, nums1, nums2));
        
        // skip from nums2
        ans = Math.max(ans, helper(i, j+1, nums1, nums2));
        
        return memo[i][j] = ans;
        
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.memo = new Integer[501][501];
        
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                ans = Math.max(ans, nums1[i]*nums2[j] + helper(i+1, j+1, nums1, nums2));
            }
        }
        return ans;
    }
}