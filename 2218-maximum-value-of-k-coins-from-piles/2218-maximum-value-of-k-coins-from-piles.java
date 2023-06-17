class Solution {
    Integer[][] memo;
    
    private int helper(int idx, int k, List<List<Integer>> piles){
        if(idx == piles.size()){
            return k == 0 ? 0 : Integer.MIN_VALUE;
        }
        
        if(memo[idx][k] != null) return memo[idx][k];
        
        int curAns = helper(idx+1, k, piles);
        
        List<Integer> pile = piles.get(idx);
        for(int i = 0; i < Math.min(pile.size(), k); i++){
            curAns = Math.max(curAns, pile.get(i) + helper(idx+1, k-(i+1), piles));
        }
        return memo[idx][k] = curAns;
    }
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for(List<Integer> pile : piles){
            for(int i = 1; i < pile.size(); i++){
                pile.set(i, pile.get(i)+pile.get(i-1));
            }
        }
        
        this.memo = new Integer[piles.size()][k+1];
        return  helper(0, k, piles);
    }
}