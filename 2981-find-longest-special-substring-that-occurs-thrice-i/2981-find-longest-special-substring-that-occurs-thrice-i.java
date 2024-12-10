class Solution {
 
    public int maximumLength(String s) {
        int n = s.length();
        
        Map<String, Integer> freq = new HashMap<>();
        for(int start = 0; start < n; start++){
            String curSubstring = "";
            for(int end = start; end < n; end++){
                if(end > start && s.charAt(end) != s.charAt(end-1)) break;
                curSubstring += s.charAt(end);
                freq.put(curSubstring, freq.getOrDefault(curSubstring, 0) + 1);
            }
        }
        
        int ans = -1;
        for(String key : freq.keySet()){
            if(freq.get(key) >= 3) ans = Math.max(ans, key.length());
        }
        
        return ans;
    }
}
