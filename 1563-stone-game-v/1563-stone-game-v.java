class Solution {
    Integer[][] memo;
    
    private int helper(int s, int e, int[] stoneValue){
        if(s == e) return 0;
        
        if(memo[s][e] != null) return memo[s][e];
        
        int totalSum = 0;
        for(int i = s; i <= e; i++) totalSum += stoneValue[i];
        
        int ans = 0;
        int leftSum = 0, rightSum = 0;
        for(int mid = s; mid < e; mid++){
            leftSum += stoneValue[mid];
            rightSum = totalSum - leftSum;
            if(leftSum < rightSum){
                ans = Math.max(ans, leftSum+helper(s, mid, stoneValue));
            }
            else if(leftSum > rightSum){
                ans = Math.max(ans, rightSum+helper(mid+1, e, stoneValue));
            }
            else{
                ans = Math.max(ans, leftSum+ Math.max(helper(s, mid, stoneValue), helper(mid+1, e, stoneValue)));
            }
        }
        
        return memo[s][e] = ans;
    }
    
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        this.memo = new Integer[n][n];
        return helper(0, n-1, stoneValue);
    }
}