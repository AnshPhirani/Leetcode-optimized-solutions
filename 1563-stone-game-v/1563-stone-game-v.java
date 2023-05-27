class Solution {
    Integer[][] memo;
    int[] prefixSum;
    
    private int helper(int s, int e){
        if(s == e) return 0;
        if(memo[s][e] != null) return memo[s][e];
    
        int ans = 0;
    
        for(int mid = s; mid < e; mid++){
            int leftSum = prefixSum[mid+1] - prefixSum[s];
            int rightSum = prefixSum[e+1] - prefixSum[mid+1];
            if(leftSum < rightSum){
                ans = Math.max(ans, leftSum+helper(s, mid));
            }
            else if(leftSum > rightSum){
                ans = Math.max(ans, rightSum+helper(mid+1, e));
            }
            else{
                ans = Math.max(ans, leftSum+ Math.max(helper(s, mid), helper(mid+1, e)));
            }
        }
        
        return memo[s][e] = ans;
    }
    
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        this.memo = new Integer[n][n];
        
        this.prefixSum = new int[n+1];
        prefixSum[0] = 0;
        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i-1] + stoneValue[i-1];
        }
        
        return helper(0, n-1);
    }
}