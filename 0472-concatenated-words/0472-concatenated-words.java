class Solution {
    
    Set<String> words;
    List<String> res;
    boolean isCancatenatedWord = false; // pruning to prevent repeated word to push into resulting list
    
    private void dfs(int start, String word){
        if(isCancatenatedWord) return;
        
        if(start == word.length()){
            res.add(word);
            isCancatenatedWord = true;
            return;
        }
        
        for(int end = start+1; end <= word.length(); end++){
            String curSubstring = word.substring(start, end);  
            if(words.contains(curSubstring)){
                dfs(end, word);
            }
        }
        
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.words = new HashSet<>(Arrays.asList(words));
        this.res = new ArrayList<>();
        
        for(String word : words){
            this.words.remove(word);
            this.isCancatenatedWord = false;
            dfs(0, word);
            this.words.add(word);
        }
        
        return res;
    }
}