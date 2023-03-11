class Solution {
    public int strStr(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        
        final int prime = 3;
        
        int patternHash = 0;
        for(int i = 0; i < m; i++){
            patternHash += (pattern.charAt(i)-'a'+1) * ((int)Math.pow(prime, i));
        }
        
        int curHash = 0;
        for(int i = 0; i < n; i++){
            if(i < m){
                curHash += (text.charAt(i)-'a'+1) * ((int)Math.pow(prime, i));
            }
            else{
                curHash -= (text.charAt(i-m)-'a'+1);
                curHash /= prime;
                curHash += (text.charAt(i)-'a'+1) * ((int)Math.pow(prime, m-1));
            }
            

            if(i >= m-1 && curHash == patternHash && text.substring(i-(m-1), i+1).equals(pattern)) return i-(m-1);
        }
        
        return -1;
        
    }
}