// very similliar code to longest palindromic subsequence

class Solution {
    
    Integer[][] memo;
    
    private int helper(int s, int e, String str){
        if(s >= e) return 0;
        
        if(memo[s][e] != null) return memo[s][e];
        
        if(str.charAt(s) == str.charAt(e)){
            return memo[s][e] =  helper(s+1, e-1, str);
        }
        else{
            return memo[s][e] = 1 + Math.min( helper(s+1, e, str), helper(s, e-1, str));
        }
        
    }
    
    public int minInsertions(String s) {
        this.memo = new Integer[s.length()][s.length()];
        
        return helper(0, s.length()-1, s);
    }

}