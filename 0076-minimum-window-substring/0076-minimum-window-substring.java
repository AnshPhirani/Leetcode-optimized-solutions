class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) return "";

        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        Map<Character, Integer> curFreq = new HashMap<>();
        
        int n = s.length();
        int matchedCount = 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int minLenStart = 0;
        
        while(end < n){
            while(matchedCount >= t.length()){
                if(end-start < minLen){
                    minLen = end-start;
                    minLenStart = start;
                }

                char ch = s.charAt(start);
                if(freqMap.containsKey(ch)){
                    if(freqMap.get(ch) >= curFreq.get(ch)) matchedCount--;
                    curFreq.put(ch, curFreq.get(ch) - 1);
                    if(curFreq.get(ch) == 0) curFreq.remove(ch);
                }
                start++;
            }
            
            
            char ch = s.charAt(end);
            if(freqMap.containsKey(ch)){
                curFreq.put(ch, curFreq.getOrDefault(ch, 0) + 1);
                if(freqMap.get(ch) >= curFreq.get(ch)){
                    matchedCount++;
                }
            }
            end++;
        }
        while(matchedCount >= t.length()){
                if(end-start < minLen){
                    minLen = end-start;
                    minLenStart = start;
                }
                char ch = s.charAt(start);
                if(freqMap.containsKey(ch)){
                    if(freqMap.get(ch) >= curFreq.get(ch)) matchedCount--;
                    curFreq.put(ch, curFreq.get(ch) - 1);
                    if(curFreq.get(ch) == 0) curFreq.remove(ch);
                }
                start++;
            }
            
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minLenStart, minLenStart+minLen);
        
    }
}