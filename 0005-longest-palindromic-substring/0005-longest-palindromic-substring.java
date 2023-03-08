class Solution {
    public String longestPalindrome(String s) {
        // modifying the string so that it works for both odd and even lenght palindrome
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for(char ch : s.toCharArray()){
            sb.append(ch+"#");
        }
        
        String str = sb.toString();
        int n = str.length();
        
        //stores longest palindrome center at i
        int[] p = new int[n];
        int center = 0, right = 0;
        
        int longestLen = 0, longestCenter = 0;
        
        for(int i = 0; i < n; i++){
            
            int mirror = 2*center - i;
            if(right > i) p[i] = Math.min(p[mirror], right-i);
            
            int a = i-(p[i]+1);
            int b = i+(p[i]+1);
            while(a >= 0 && b < str.length() && str.charAt(a) == str.charAt(b)){
                a--;
                b++;
                p[i]++;
            }
            
            if(p[i] > longestLen){
                longestCenter = i;
                longestLen = p[i];
            }
            
            if(i+p[i] > right){
                right = i+p[i];
                center = i;
            }
            
        }
        
        return str.substring(longestCenter-longestLen, longestCenter + longestLen).replace("#", "");
        
    }
}