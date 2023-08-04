class Solution {
    Set<String> dict;
    Boolean[] memo;
    
    private boolean helper(int idx, String s){
        if(idx == s.length()) return true;
        
        if(memo[idx] != null) return memo[idx];
        
        String curWord = "";
        for(int j = idx; j < s.length(); j++){
            curWord += s.charAt(j);
            if(dict.contains(curWord) && helper(j+1, s)) 
                return memo[idx] = true;
        }
        
        return memo[idx] = false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dict = new HashSet<>(wordDict);
        this.memo = new Boolean[s.length()];
        return helper(0, s);
    }
}