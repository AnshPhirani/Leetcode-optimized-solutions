class Solution {
    
    Integer[][] memo;
    
    private int helper(int s, int e, String str){
        if(s > e) return 0;
        if(s == e) return 1;
        
        if(memo[s][e] != null) return memo[s][e];
        
        if(str.charAt(s) == str.charAt(e)){
            return memo[s][e] = 2 + helper(s+1, e-1, str);
        }
        else{
            return memo[s][e] = Math.max(helper(s+1, e, str), helper(s, e-1, str));
        }
        
    }
    
    public int longestPalindromeSubseq(String s) {
        this.memo = new Integer[s.length()][s.length()];
        
        return helper(0, s.length()-1, s);
    }
}