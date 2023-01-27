class Solution {
    
    Set<String> words;
    
    private boolean dfs(int start, String word){

        if(start == word.length()){
            return true;
        }
        
        for(int end = start+1; end <= word.length(); end++){
            String curSubstring = word.substring(start, end);  
            if(words.contains(curSubstring) && dfs(end, word)){
                return true;
            }
        }
        return false;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.words = new HashSet<>(Arrays.asList(words));
        List<String> res = new ArrayList<>();
        
        for(String word : words){
            this.words.remove(word);
            if(dfs(0, word)) res.add(word);
            this.words.add(word);
        }
        
        return res;
    }
}