class Solution {
    private int dfs(int l, int r, int turn, int[] piles){
        if(l > r) return 0;
        if(turn == 0){
            int left = piles[l] + dfs(l+1, r, 1, piles);
            int right = piles[r] + dfs(l, r-1, 1, piles);
            return Math.max(left, right);
        }
        else{
            int left = -piles[l] + dfs(l+1, r, 0, piles);
            int right = -piles[r] + dfs(l, r-1, 0, piles);
            return Math.min(left, right);
        }
    }

    public boolean PredictTheWinner(int[] piles) {
        return dfs(0, piles.length-1, 0, piles) >= 0;
    }
}