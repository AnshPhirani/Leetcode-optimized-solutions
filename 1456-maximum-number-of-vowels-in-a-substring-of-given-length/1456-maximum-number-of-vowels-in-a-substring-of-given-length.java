class Solution {
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {
        int curVowelFreq = 0, maxVowelFreq = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))) curVowelFreq++;
            if(i >= k && isVowel(s.charAt(i-k))) curVowelFreq--;
            
            maxVowelFreq = Math.max(maxVowelFreq, curVowelFreq);
        }
        
        return maxVowelFreq;
    }
}