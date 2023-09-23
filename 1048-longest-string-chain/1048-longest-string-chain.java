class Solution {
    Map<String, Integer> dp;
    
    private int helper(String word, Set<String> words){
        
        if(dp.containsKey(word)) return dp.get(word);
        
        int len = 1;
        for(int i = 0; i < word.length(); i++){
            String predecessor = word.substring(0, i) + word.substring(i+1);
            if(!words.contains(predecessor)) continue;
            int predecessorAns =  helper(predecessor, words);
            len = Math.max(len, 1 + predecessorAns);
        }
        
        dp.put(word, len);
        return len;
    }
    
    public int longestStrChain(String[] words) {
        this.dp = new HashMap<>();
        
        Set<String> set = new HashSet<>();
        for(String word : words) set.add(word);
        
        int ans = 0;
        for(String word : words){
            ans = Math.max(ans, helper(word, set));
        }
        
        return ans;
        
    }
}