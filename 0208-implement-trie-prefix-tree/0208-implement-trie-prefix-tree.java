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

class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode('\0');
    }
    
    public void insert(String word) {
        TrieNode curRoot = this.root;
        
        for(char ch : word.toCharArray()){
            if(curRoot.childrens[ch-'a'] == null){
                curRoot.childrens[ch-'a'] = new TrieNode(ch);
            }
            curRoot = curRoot.childrens[ch-'a'];
        }
        curRoot.isTerminating = true;
    }
    
    public boolean search(String word) {
        TrieNode curRoot = this.root;
        
        for(char ch : word.toCharArray()){
            if(curRoot.childrens[ch-'a'] == null){
                return false;
            }
            curRoot = curRoot.childrens[ch-'a'];
        }
        
        return curRoot.isTerminating;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curRoot = this.root;
        
        for(char ch : prefix.toCharArray()){
            if(curRoot.childrens[ch-'a'] == null){
                return false;
            }
            curRoot = curRoot.childrens[ch-'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */