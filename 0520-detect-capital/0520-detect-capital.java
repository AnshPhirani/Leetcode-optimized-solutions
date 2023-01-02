class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        boolean firstCapital = false;
        int remainingCapitals = 0;
        int remainingSmall = 0;
        
        if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){
            firstCapital = true;
        }
        
        for(int i = 1; i < n; i++){
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                remainingCapitals++;
            }
            else if(ch >= 'a' && ch <= 'z'){
                remainingSmall++;
            }
        }
        
        if(firstCapital && (remainingCapitals == n-1 || remainingSmall == n-1)) return true;
        else if(!firstCapital && remainingSmall == n-1) return true;
        else return false;
    }
}