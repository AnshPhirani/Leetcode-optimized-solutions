class Solution {
    
    int[][] freq;
    Long[][] memo;
    final static int MOD = (int)1e9 + 7;
    
    private long helper(int k, int idx, int n, String target){
        if(idx == target.length()) return 1;
        if(k == n) return 0;
        
        if(memo[k][idx] != null) return memo[k][idx];
        
        char cur = target.charAt(idx);
        long res = 0;
        
        // selecting from the kth position
        long select = (freq[k][cur-'a'] * helper(k+1, idx+1, n, target)%MOD)%MOD;
        res = (res + select)%MOD;

        // skipping the kth position
        long skip = helper(k+1, idx, n, target);
        res = (res + skip)%MOD;
        
        return memo[k][idx] = res%MOD;
    
    }
    
    public int numWays(String[] words, String target) {
        int n= words[0].length();
        this.freq = new int[n][26];
        this.memo = new Long[n][target.length()];
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = 0; j < n; j++){
                char ch = word.charAt(j);
                freq[j][ch-'a']++;
            }
        }
        
        
        
        return (int)helper(0, 0, n, target);
        
    }
}