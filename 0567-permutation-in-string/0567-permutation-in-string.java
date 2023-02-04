class Solution {
    
    private boolean isPermutation(int[] freq1, int[] freq2){
        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;
        
        int[] freq = new int[26];
        for(char ch : s1.toCharArray()){
            freq[ch-'a']++;
        }
        
        int n = s2.length();
        int[] freq2 = new int[26];
        int idx = 0;
        
        while(idx < n){
            if(idx >= s1.length()){
                char starting = s2.charAt(idx - s1.length());
                freq2[starting-'a']--;
            }
            char ch = s2.charAt(idx);
            freq2[ch-'a']++;
            
            if(isPermutation(freq, freq2)) return true;
            idx++;
        }
        
        return false;
        
    }
}