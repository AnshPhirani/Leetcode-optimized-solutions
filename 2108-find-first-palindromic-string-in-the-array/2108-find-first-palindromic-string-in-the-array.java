class Solution {
    
    private boolean isPalindrome(String str){
        int l = 0, r = str.length()-1;
        while(l < r){
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    
    public String firstPalindrome(String[] words) {
        for(String word : words) if(isPalindrome(word)) return word;
        return "";
    }
}