class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length()-1, m = t.length()-1;
        while(n >= 0 || m >= 0){
            int backspaceCount = 0;
            while(n >= 0 && (s.charAt(n) == '#' || backspaceCount > 0)){
                if(s.charAt(n) == '#') backspaceCount++;
                else backspaceCount--;
                n--;
            }
            
            backspaceCount = 0;
            while(m >= 0 && (t.charAt(m) == '#' || backspaceCount > 0)){
                if(t.charAt(m) == '#') backspaceCount++;
                else backspaceCount--;
                m--;
            }
            
            if(n >= 0 && m >= 0 && s.charAt(n) != t.charAt(m)) return false;
            else if((n >= 0 && m < 0) || (n < 0 && m >= 0)) return false;
            n--;
            m--;
        }
        
        return true;     
    }
}