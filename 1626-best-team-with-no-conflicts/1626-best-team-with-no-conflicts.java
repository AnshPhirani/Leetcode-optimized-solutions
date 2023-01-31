class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] players = new int[n][2];
        for(int i = 0; i < n; i++){
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        
        Arrays.sort(players, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        
        int[] dp = new int[n];
        
        int maxScore = 0;
        for(int i = 0; i < n; i++){
            dp[i] = players[i][1];
            for(int j = i-1; j >= 0; j--){
                if(players[j][1] <= players[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + players[i][1]);
                }
            }
            maxScore = Math.max(maxScore, dp[i]);
        }
        
        return maxScore;
    }
}