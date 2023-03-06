class Solution {
    
    private int palindromeCount(String s, int l, int r){
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
    
    public int countSubstrings(String s) {
        
        int res = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            res += 1 + palindromeCount(s, i-1, i+1);
            res += palindromeCount(s, i, i+1);
        }
        
        return res;
    }
}