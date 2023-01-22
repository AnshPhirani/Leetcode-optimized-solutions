class Solution {
    List<List<String>> res;
    boolean[][] isPalindrome;
    
    private void buildIsPalindrome(String str, int n){
        for(int g = 0; g < n; g++){
            int s = 0;
            for(int e = g; e < n; s++, e++){
                if(str.charAt(s) == str.charAt(e)){
                    if(g == 0 || g == 1 || isPalindrome[s+1][e-1]){
                        isPalindrome[s][e] = true;
                    }
                }
            }
        }
        return;
    }
    
    private void helper(int start, String s, List<String> curPartition){
        if(start == s.length()){
            res.add(new ArrayList<>(curPartition));
            return;
        }
        
        for(int end = start; end < s.length(); end++){
            if(isPalindrome[start][end]){
                curPartition.add(s.substring(start, end+1));
                helper(end+1, s, curPartition);
                curPartition.remove(curPartition.size()-1);
            }
        }
        
    }
    
    public List<List<String>> partition(String s) {
        int n = s.length();
        this.res = new ArrayList<>();
        this.isPalindrome = new boolean[n][n];
        
        buildIsPalindrome(s, n);
        
        helper(0, s, new ArrayList<>());
        return res;
    }
}