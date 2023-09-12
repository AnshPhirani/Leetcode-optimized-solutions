class Solution {
    public int minDeletions(String s) {
        
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) freq[ch-'a']++;
        
        int maxFreq = 0;
        Map<Integer, Integer> freqToCharCount = new HashMap<>();
        for(int f : freq){
            if(f == 0) continue;
            freqToCharCount.put(f, freqToCharCount.getOrDefault(f, 0) + 1);
            maxFreq = Math.max(f, maxFreq);
        }

        int deletions = 0;
        for(int curFreq = maxFreq; curFreq > 0; curFreq--){
            int charCount = freqToCharCount.getOrDefault(curFreq, 0);
            if(charCount <= 1) continue;
            deletions += charCount-1;
            freqToCharCount.put(curFreq-1, freqToCharCount.getOrDefault(curFreq-1, 0) + charCount-1);
        }
        return deletions;
        
    }
}