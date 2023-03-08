class Solution {
    
    // maximum palindrome length center between left and right
    private int maxPalindromeLen(String str, int left, int right){
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return right-left-1; 
    }
    
    public String longestPalindrome(String str) {
        int n = str.length();
        
        int maxPalindromeLen = 0;
        int maxPalindromeStart = 0;
        
        for(int i = 0; i < n; i++){
            int oddPalindromeLen = maxPalindromeLen(str, i-1, i+1);
            int evenPalindromeLen = maxPalindromeLen(str, i, i+1);
            if(oddPalindromeLen > maxPalindromeLen){
                maxPalindromeStart = i - oddPalindromeLen/2;
                maxPalindromeLen = oddPalindromeLen;
            }
            if(evenPalindromeLen > maxPalindromeLen){
                maxPalindromeStart = i - evenPalindromeLen/2 + 1;
                maxPalindromeLen = evenPalindromeLen;
            }
        }
        
        
        return str.substring(maxPalindromeStart, maxPalindromeStart + maxPalindromeLen);
        
    }
}