class Solution {
    
    private boolean includeIfPossible(String word, int[] freq){
        boolean canInclude = true;
        for(char ch : word.toCharArray()){
            if(freq[ch - 'a'] > 0) canInclude = false;
            freq[ch-'a']++;
        }
        
        if(canInclude) return true;
        for(char ch : word.toCharArray()) freq[ch-'a']--;
        return false;
        
    }
    
    private int helper(int idx, List<String> arr, int[] freq){
        if(idx == arr.size()){
            return 0;
        }
        
        int skip = helper(idx+1, arr, freq);
        int include = 0;
        String word = arr.get(idx);
        if(includeIfPossible(word, freq)){
            include = word.length() +  helper(idx+1, arr, freq);
            
            for(char ch : word.toCharArray()) freq[ch-'a']--;
        }
        return Math.max(skip, include);
    }
    
    public int maxLength(List<String> arr) {
        return helper(0, arr, new int[26]);
    }
}