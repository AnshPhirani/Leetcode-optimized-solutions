class Solution {
    
    Integer[] memo;
    
    private int helper(int start, String s, Set<String> dict){
        if(start == s.length()) return 0;
        
        if(memo[start] != null) return memo[start];
        
        // skip current character
        int ans = 1 + helper(start+1, s, dict);
        
        String curSubstring = "";
        for(int end = start; end < s.length(); end++){
            curSubstring += s.charAt(end);
            if(dict.contains(curSubstring))
                ans = Math.min(ans, helper(end+1, s, dict));
        }
        
        return memo[start] = ans;
        
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        this.memo = new Integer[s.length()];
        Set<String> dict = new HashSet<>();
        for(String word : dictionary) dict.add(word);
        
        return helper(0, s, dict);
        
    }
}