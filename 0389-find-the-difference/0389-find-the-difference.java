class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        
        for(char ch : t.toCharArray()){
            freq[ch-'a']--;
            if(freq[ch-'a'] == -1) return ch;
        }
        
        return '\0';
        
    }
}