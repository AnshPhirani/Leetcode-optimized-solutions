class Solution {
    
    private boolean canDivide(String s, String t){
        int n = t.length();
        
        if(s.length()%n != 0) return false;
        
        int idx = 0;
        for(char ch : s.toCharArray()){
            if(ch != t.charAt(idx)) return false;
            idx = (idx+1)%n;
        }
        
        return true;
    }
    
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        String gcd = "";
        String prefix = "";
        for(int i = Math.min(n, m); i >= 1; i--){
            String divisor = str1.substring(0, i);
            if(canDivide(str1, divisor) && canDivide(str2, divisor)){
                return divisor;
            }
        }
        
        return "";
    }
}