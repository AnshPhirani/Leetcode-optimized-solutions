class Solution {
    Integer[][] memo;
    
    private int dfs(int idx, List<List<Integer>> piles, int k){
        if(k == 0) return 0;
        if(idx == piles.size()) return Integer.MIN_VALUE;
        
        if(memo[idx][k] != null) return memo[idx][k];
        
        int res = Integer.MIN_VALUE;
        
        // skip choosing from current pile
        res = Math.max(res, dfs(idx+1, piles, k));
        
        // choose from current pile
        List<Integer> pile = piles.get(idx);
        int size = pile.size();
        int curSum = 0;
        for(int j = 0; j < Math.min(size, k); j++){
            curSum += pile.get(j);
            res = Math.max(res, curSum + dfs(idx+1, piles, k-(j+1)));
        }
        
        return memo[idx][k] = res;
        
    }
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.memo = new Integer[piles.size()][k+1];
        return dfs(0, piles, k);
    }
}