class Solution {
 
    public int maximumLength(String s) {
        int n = s.length();
        
        Map<Pair<Character, Integer>, Integer> freq = new HashMap<>();
        for(int start = 0; start < n; start++){
            char curChar = s.charAt(start);
            for(int end = start; end < n; end++){
                if(s.charAt(end) != curChar) break;
                Pair<Character, Integer> curPair = new Pair<>(curChar, end-start+1);
                freq.put(curPair, freq.getOrDefault(curPair, 0) + 1);
            }
        }
        
        int ans = -1;
        for(Pair<Character, Integer> key : freq.keySet()){
            if(freq.get(key) >= 3) ans = Math.max(ans, key.getValue());
        }
        
        return ans;
    }
}
