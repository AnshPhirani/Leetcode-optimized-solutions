class Solution {
    
    Integer[][] memo;
    
    private int helper(int i, int j, int s, int e, int[] cuts){
        if(s > e) return 0;
        
        if(memo[s][e] != null) return memo[s][e];
        
        int curLen = j-i;
        int curAns = Integer.MAX_VALUE;
        
        for(int k = s; k <= e; k++){
            int cutIdx = cuts[k];
            curAns = Math.min(curAns, curLen + helper(i, cutIdx, s, k-1, cuts) + helper(cutIdx, j, k+1, e, cuts));
        }
        
        return memo[s][e] = curAns;
        
    }
    
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        this.memo = new Integer[len][len];
        Arrays.sort(cuts);
        
        return helper(0, n, 0, len-1, cuts);
    }
}