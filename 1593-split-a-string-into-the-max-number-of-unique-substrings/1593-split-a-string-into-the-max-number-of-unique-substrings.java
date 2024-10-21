class Solution {
    
    private int helper(int start, String s, HashSet<String> seen){
        if(start == s.length()) return 0;
        
        int splitCount = 0;
        String cur = "";
        for(int end = start; end < s.length(); end++){
            cur += s.charAt(end);
            if(!seen.contains(cur)){
                seen.add(cur);
                splitCount = Math.max(splitCount, 1 + helper(end+1, s, seen));
                seen.remove(cur);
            }
        }
        
        return splitCount;
    }
    
    public int maxUniqueSplit(String s) {
        return helper(0, s, new HashSet<>());
    }
}