class Solution {
    List<List<String>> res;
    
    private boolean isPalindrome(String str, int s, int e){
        while(s < e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
    
    private void helper(int start, String s, List<String> curPartition){
        if(start == s.length()){
            res.add(new ArrayList<>(curPartition));
            return;
        }
        
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                curPartition.add(s.substring(start, end+1));
                helper(end+1, s, curPartition);
                curPartition.remove(curPartition.size()-1);
            }
        }
        
    }
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(0, s, new ArrayList<>());
        return res;
    }
}