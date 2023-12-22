class Solution {
    public int maxScore(String s) {
        int zeros = 0, ones = 0;
        for(char ch : s.toCharArray()){
            if(ch == '0') zeros++;
            else ones++;
        }
        
        int ans = 0;
        int leftZeros = 0, leftOnes = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '0') leftZeros++;
            else leftOnes++;
            
            int curScore = leftZeros + ones - leftOnes;
            ans = Math.max(ans, curScore);
        }
        
        return ans;
    }
}