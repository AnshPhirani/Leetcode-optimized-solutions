class Solution {
    
    Map<String, Boolean> memo = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        
        String key = s1 + "*" + s2;
        if(memo.containsKey(key)) return memo.get(key);
        
        int[] freq1 = new int[26];
        for(char ch : s1.toCharArray()) freq1[ch-'a']++;
        
        int[] freq2 = new int[26];
        for(char ch : s2.toCharArray()) freq2[ch-'a']++;
        
        if(!Arrays.equals(freq1, freq2)) return false;
        
        int n = s1.length();
        
        for(int i = 1; i < n; i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                memo.put(key, true);
                return true;
            }
            if(isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i))){
                memo.put(key, true);
                return true;    
            }
        }
        
        memo.put(key, false);
        return false;
    }
}