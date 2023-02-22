class Solution {
    
    Set<String> dictionary;
    List<String> res;
    
    private void dfs(int start, String s, String curSentence){
        if(start == s.length()){
            res.add(curSentence.substring(1));
            return;
        }
        
        for(int end = start; end < s.length(); end++){
            String curWord = s.substring(start, end+1);
            if(dictionary.contains(curWord)){
                dfs(end+1, s, curSentence + " " + curWord);
            }
        }
        
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.dictionary = new HashSet<>();
        this.res = new ArrayList<>();
        
        for(String word : wordDict) dictionary.add(word);
        
        dfs(0, s, "");
        
        return res;
    }
}