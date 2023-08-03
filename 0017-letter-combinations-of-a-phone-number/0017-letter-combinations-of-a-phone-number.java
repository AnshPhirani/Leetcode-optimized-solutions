class Solution {
    static Map<Integer, String> map = new HashMap<>();
    
    List<String> res;
    
    private void helper(int idx, String digits, String cur){
        if(idx == digits.length()){
            res.add(cur);
            return;
        }
        
        for(char ch : map.get(digits.charAt(idx)-'0').toCharArray()){
            helper(idx+1, digits, cur+ch);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        this.res = new ArrayList<>();
        helper(0, digits, "");
        return res;
    }
}