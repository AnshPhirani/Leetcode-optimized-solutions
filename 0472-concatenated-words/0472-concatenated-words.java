class Solution {
    
    Set<String> words;
    Set<String> res;
    
    private void dfs(int start, String word){
        if(start == word.length()){
            res.add(word);
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
        this.res = new HashSet<>();
        
        for(String word : words){
            this.words.remove(word);
            dfs(0, word);
            this.words.add(word);
        }
        
        return new ArrayList<>(res);
    }
}