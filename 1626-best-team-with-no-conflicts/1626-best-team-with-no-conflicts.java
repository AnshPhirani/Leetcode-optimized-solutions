class Solution {
    
    Integer[][] memo;
    
    private int helper(int idx, int prev, int[][] players){
        if(idx == players.length) return 0;
        
        if(prev != -1 && memo[idx][prev] != null) return memo[idx][prev];
        
        // including the current player
        int including = 0;
        if(prev == -1 || players[prev][1] <= players[idx][1]){
            including = players[idx][1] + helper(idx+1, idx, players);
        }
        
        // exculding the current element
        int excluding = helper(idx+1, prev, players);
        
        
        if(prev != -1) memo[idx][prev] = Math.max(including, excluding);
        return Math.max(including, excluding);
        
    }
    
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] players = new int[n][2];
        for(int i = 0; i < n; i++){
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        Arrays.sort(players, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        
        this.memo = new Integer[n][n];
        return helper(0, -1, players);
    }
}