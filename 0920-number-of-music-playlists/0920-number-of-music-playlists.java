class Solution {
    
    private static final int MOD = (int)1e9 + 7;
    private Map<Pair<Integer, Integer>, Long> memo;
    
    private long helper(int curGoal, int oldSongs, int n, int k){
        if(curGoal == 0 && oldSongs == n) return 1;
        if(curGoal == 0 || oldSongs > n) return 0;
        
        Pair<Integer, Integer> key = new Pair(curGoal, oldSongs);
        if(memo.containsKey(key)) return memo.get(key);
        
        long res = 0;
        // choose new song
        res += (n-oldSongs) * helper(curGoal-1, oldSongs+1, n, k);
        res %= MOD;
        
        // choose old song
        if(oldSongs > k){
            res += (oldSongs-k) * helper(curGoal-1, oldSongs, n, k);
        }
        
        memo.put(key, res%MOD);
        return memo.get(key);
    }
    
    public int numMusicPlaylists(int n, int goal, int k) {
        this.memo = new HashMap<>();
        return (int) helper(goal, 0, n, k);
    }
}