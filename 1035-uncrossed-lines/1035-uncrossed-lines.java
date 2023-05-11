class Solution {
    Integer[][] memo;
    
    private int dfs(int i, int j, int[] nums1, int[] nums2){
        if(i == nums1.length || j == nums2.length) return 0;
        
        if(memo[i][j] != null) return memo[i][j];
        
        if(nums1[i] == nums2[j]) return memo[i][j] = 1 + dfs(i+1, j+1, nums1, nums2);
        
        return memo[i][j] = Math.max(dfs(i+1, j, nums1, nums2), dfs(i, j+1, nums1, nums2));
        
    }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        memo = new Integer[nums1.length][nums2.length];
        return dfs(0, 0, nums1, nums2);
    }
}