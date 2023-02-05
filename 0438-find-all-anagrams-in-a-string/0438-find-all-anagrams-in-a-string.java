class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        if(p.length() > s.length()) return res;
        
        int[] freq = new int[26];
        for(char ch : p.toCharArray()){
            freq[ch-'a']++;
        }
        
        int n = s.length();
        int[] curFreq = new int[26];
        int idx = 0;
        
        while(idx < n){
            if(idx >= p.length()){
                char starting = s.charAt(idx - p.length());
                curFreq[starting-'a']--;
            }
            char ch = s.charAt(idx);
            curFreq[ch-'a']++;
            
            if(Arrays.equals(freq, curFreq)) res.add(idx-p.length()+1);
            idx++;
        }
        
        return res;
    }
}