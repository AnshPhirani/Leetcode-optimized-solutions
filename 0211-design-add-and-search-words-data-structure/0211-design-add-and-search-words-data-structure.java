class TrieNode{
    char data;
    TrieNode[] childrens;
    boolean isTerminating;
    
    public TrieNode(char data){
        this.data = data;
        this.isTerminating = false;
        this.childrens = new TrieNode[26];
    }
    
}

class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode('\0');
    }
    
    public void addWord(String word) {
        TrieNode curRoot = this.root;
        
        for(char ch : word.toCharArray()){
            if(curRoot.childrens[ch-'a'] == null){
                curRoot.childrens[ch-'a'] = new TrieNode(ch);
            }
            curRoot = curRoot.childrens[ch-'a'];
        }
        curRoot.isTerminating = true;
    }
    
    private boolean search(int idx, String word, TrieNode root){
        if(idx == word.length()) return root.isTerminating;
        
        char ch = word.charAt(idx);

        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(root.childrens[i] != null && search(idx+1, word, root.childrens[i])) return true;
            }
            return false;
        }
        
        if(root.childrens[ch-'a'] == null){
            return false;
        }
        else{
            return search(idx+1, word, root.childrens[ch-'a']);
        }
        
    }
    
    public boolean search(String word) {
        return search(0, word, root);
    }
}



/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */