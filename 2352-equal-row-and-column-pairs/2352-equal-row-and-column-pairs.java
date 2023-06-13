class TrieNode{
    int count;
    Map<Integer, TrieNode> childrens;

    public TrieNode(){
        this.count = 0;
        this.childrens = new HashMap<>();
    }
}


class Trie{
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(int[] arr){
        TrieNode curRoot = root;
        for(int a : arr){
            if(!curRoot.childrens.containsKey(a)) curRoot.childrens.put(a, new TrieNode());
            curRoot = curRoot.childrens.get(a);
        }
        curRoot.count += 1;
    }
    
    public int search(int[] arr){
        TrieNode curRoot = root;
        for(int a : arr){
            if(!curRoot.childrens.containsKey(a)) return 0;
            curRoot = curRoot.childrens.get(a);
        }
        return curRoot.count;
    }
    
}

class Solution {
    
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        
        Trie trie = new Trie();
        int count = 0;
        
        for(int r = 0; r < n; r++){
            int[] row = grid[r];
            trie.insert(row);
        }
        
        
        for(int c = 0; c < n; c++){
            int[] col = new int[n];
            for(int r = 0; r < n; r++){
                col[r] = grid[r][c];
            }
            count += trie.search(col);
        }
        
        return count;
    }
}