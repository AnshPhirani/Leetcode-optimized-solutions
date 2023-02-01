class Solution {
    
    private boolean canDivide(String s, String t){
        int n = t.length();
        int idx = 0;
        for(char ch : s.toCharArray()){
            if(ch != t.charAt(idx)) return false;
            idx = (idx+1)%n;
        }
        
        return idx == 0;
    }
    
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if(n < m) return gcdOfStrings(str2, str1);
        
        String gcd = "";
        String prefix = "";
        for(int i = 0; i < m; i++){
            if(str2.charAt(i) != str1.charAt(i)) return "";
            prefix += str2.charAt(i);
            if(canDivide(str1, prefix) && canDivide(str2, prefix)){
                gcd = prefix;
            }
        }
        
        return gcd;
    }
}