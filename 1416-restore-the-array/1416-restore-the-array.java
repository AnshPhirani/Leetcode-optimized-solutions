class Solution {
    
    private final int MOD = (int)1e9+7;
    Integer[] memo;
    
    private int dfs(int start, String str, long k){ 
        if(start == str.length()) return 1;
        if(str.charAt(start) == '0') return 0;
        
        if(memo[start] != null) return memo[start];
        
        int ways = 0;
        long curNum = 0;
        for(int end = start; end < str.length(); end++){
            curNum = curNum*10 + str.charAt(end) - '0';
            if(curNum > k) break;
            ways += dfs(end+1, str, k);
            ways %= MOD;
        }
        
        return memo[start] = ways%MOD;
    }
    
    public int numberOfArrays(String s, int k) {
        this.memo = new Integer[s.length()];
        return dfs(0, s, k);
    }
}
