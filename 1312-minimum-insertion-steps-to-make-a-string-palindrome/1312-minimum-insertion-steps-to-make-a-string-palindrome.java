class Solution {
    Integer[][] memo;
    
    private int dfs(String str, int s, int e){
        if(s >= e) return 0;
        if(memo[s][e] != null) return memo[s][e];
        if(str.charAt(s) == str.charAt(e)){
            return memo[s][e] = dfs(str, s+1, e-1);
        }
        else{
            return memo[s][e] = 1+Math.min(dfs(str, s+1, e), dfs(str, s, e-1));
        }
    }
    
    public int minInsertions(String s) {
        this.memo = new Integer[s.length()][s.length()];
        return dfs(s, 0, s.length()-1);
    }
}