class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        
        
        int diffCount = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)) diffCount++;
            freq1[s.charAt(i)-'a']++;
            freq2[goal.charAt(i)-'a']++;
        }
        
        if(!Arrays.equals(freq1, freq2)) return false; 
        if(diffCount == 2) return true;
        for(int freq : freq2){
            if(freq > 1 && diffCount == 0) return true;
        }
        
        return false;
        
    }
}