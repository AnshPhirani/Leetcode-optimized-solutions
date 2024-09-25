class TrieNode{
    char val;
    TrieNode[] childrens;
    int count;
    
    public TrieNode(char val){
        this.val = val;
        this.childrens = new TrieNode[26];
        this.count = 0;   
    }
}

class Solution {
    
    private void addToTrie(TrieNode root, String word){    
        if(word.length() == 0) return;
        
        char ch = word.charAt(0);
        if(root.childrens[ch-'a'] == null) 
            root.childrens[ch-'a'] = new TrieNode(ch);
        
        root.childrens[ch-'a'].count++;
        addToTrie(root.childrens[ch-'a'], word.substring(1));
    }
    
    private int prefixCount(TrieNode root, String word){
        if(word.length() == 0) return 0;
        
        char ch = word.charAt(0);
        if(root.childrens[ch-'a'] == null) return root.count;
        
        return root.childrens[ch-'a'].count + prefixCount(root.childrens[ch-'a'], word.substring(1));
    }
    
    public int[] sumPrefixScores(String[] words) {
        
        TrieNode root = new TrieNode('\0');
        
        for(String word : words){
            addToTrie(root, word);
        }
        
        int[] ans = new int[words.length];
        int idx = 0;
        for(String word : words){
            ans[idx++] = prefixCount(root, word);
        }
        
        return ans;
    }
}