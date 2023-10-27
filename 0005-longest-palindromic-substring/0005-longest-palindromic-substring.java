class Solution {
    
    public String longestPalindrome(String s) {
        int n = s.length();
        int longestPalindromeLen = 0;
        String longestPalindromeString = "";
        
        for(int idx = 0; idx < 2*n; idx++){
            int curPalindromeLen = 0;
            int leftIdx = idx/2;
            int rightIdx = (idx+1)/2;
            while(leftIdx >= 0 && rightIdx < n && s.charAt(leftIdx) == s.charAt(rightIdx)){
                curPalindromeLen += (leftIdx == rightIdx) ? 1 : 2;
                leftIdx--;
                rightIdx++;
            }
            if(curPalindromeLen > longestPalindromeLen){
                longestPalindromeLen = curPalindromeLen;
                longestPalindromeString = s.substring(leftIdx+1, rightIdx);
            }
            
        }
        
        return longestPalindromeString;
    }
}