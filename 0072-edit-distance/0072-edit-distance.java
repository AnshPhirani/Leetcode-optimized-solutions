class Solution {
    
    Integer[][] memo;
    
    private int helper(int idx1, int idx2, String word1, String word2){
        if(idx1 == word1.length()) return word2.length()-idx2;
        if(idx2 == word2.length()) return word1.length()-idx1;
        
        if(memo[idx1][idx2] != null) return memo[idx1][idx2];
        
        if(word1.charAt(idx1) == word2.charAt(idx2)){
            return helper(idx1+1, idx2+1, word1, word2);
        }
        
        int insert = 1 + helper(idx1, idx2+1, word1, word2);
        int delete = 1 + helper(idx1+1, idx2, word1, word2);
        int replace = 1 + helper(idx1+1, idx2+1, word1, word2);
        return memo[idx1][idx2] = Math.min(insert, Math.min(delete, replace));
    }
    
    public int minDistance(String word1, String word2) {
        this.memo = new Integer[word1.length()][word2.length()];
    
        return helper(0, 0, word1, word2);
    }
}