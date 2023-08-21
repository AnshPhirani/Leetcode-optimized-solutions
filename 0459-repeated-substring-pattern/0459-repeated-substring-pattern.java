class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        for(int len = 1; len <= n/2; len++){
            if(n%len != 0) continue;
            String cur = s.substring(0, len);
            String next = "";
            int i = len;
            for(; i < n; i++){
                next += s.charAt(i);
                if(cur.length() == next.length()){
                    if(!cur.equals(next)) break;
                    else next = "";
                }
            }
            if(i == n) return true;
        }
        
        return false;
        
    }
}