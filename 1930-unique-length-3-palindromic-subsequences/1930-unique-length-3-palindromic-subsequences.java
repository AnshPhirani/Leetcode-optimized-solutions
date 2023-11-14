class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        Set<Character> letters = new HashSet<>();
        for(char ch : s.toCharArray()) letters.add(ch);
        
        for(char letter : letters){
            int firstIdx = -1;
            int lastIdx = -1;
            for(int idx = 0; idx < s.length(); idx++){
                if(s.charAt(idx) != letter) continue;
                if(firstIdx == -1) firstIdx = idx;
                lastIdx = idx;
            }
            
            Set<Character> betweens = new HashSet<>();
            for(int idx = firstIdx+1; idx < lastIdx; idx++) betweens.add(s.charAt(idx));
            
            ans += betweens.size();
        }
        
        return ans;
    }
}