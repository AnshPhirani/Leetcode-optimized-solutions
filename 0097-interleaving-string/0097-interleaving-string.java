class Solution {
    
    Boolean[][] memo;
    String s1, s2, s3;
    
    private boolean helper(int idx1, int idx2, int idx3){
        if(idx1 == s1.length() && idx2 == s2.length()) return true;
        if(idx1 == s1.length()){
            return s2.charAt(idx2) == s3.charAt(idx3) ? helper(idx1, idx2+1, idx3+1) : false;
        }   
        if(idx2 == s2.length()){
            return s1.charAt(idx1) == s3.charAt(idx3) ? helper(idx1+1, idx2, idx3+1) : false;
        }
        
        
        if(memo[idx1][idx2] != null) return memo[idx1][idx2];
        
        boolean ans = false;
        
        if(s1.charAt(idx1) == s3.charAt(idx3)) ans |= helper(idx1+1, idx2, idx3+1);
        if(s2.charAt(idx2) == s3.charAt(idx3)) ans |= helper(idx1, idx2+1, idx3+1);
        
        return memo[idx1][idx2] = ans;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length()) return false;
        
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.memo = new Boolean[s1.length()][s2.length()];
        
        return helper(0, 0, 0);
    }
}