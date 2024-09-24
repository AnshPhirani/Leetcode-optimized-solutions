class TrieNode {
    TrieNode[] childrens;
    boolean isTerminating;
    
    public TrieNode(){
        this.childrens = new TrieNode[10];
        this.isTerminating = false;
    } 
}

class Solution {
    
    
    private void addNumberToTrie(TrieNode root, String num){
        if(num.length() == 0){
            root.isTerminating = true;
            return;
        }
        
        if(root.childrens[num.charAt(0)-'0'] == null) root.childrens[num.charAt(0)-'0'] = new TrieNode();
        addNumberToTrie(root.childrens[num.charAt(0)-'0'], num.substring(1));
            
    }
    
    private int maxCommonPrefixLength(TrieNode root, String num){
        if(num.length() == 0) return 0;
        
         if(root.childrens[num.charAt(0)-'0'] != null)
             return 1 + maxCommonPrefixLength(root.childrens[num.charAt(0)-'0'], num.substring(1));
        
        return 0;
        
    }
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        for(int num : arr1) addNumberToTrie(root, String.valueOf(num));
        
        int maxLen = 0;
        for(int num : arr2){
            maxLen = Math.max(maxLen, maxCommonPrefixLength(root, String.valueOf(num)));
        }
        
        return maxLen;
    }
}

