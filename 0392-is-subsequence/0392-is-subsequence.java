class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int k = 0;
        for(char ch : t.toCharArray()){
            if(s.charAt(k) == ch) k++;
            if(k == s.length()) return true;
        }
        return false;
    }
}