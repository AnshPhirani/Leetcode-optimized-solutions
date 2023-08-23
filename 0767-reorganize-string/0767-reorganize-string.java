class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        
        int[] freq = new int[26];
        int maxFreq = 0, maxFreqChar = 0;
        
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
            if(maxFreq < freq[ch-'a']){
                maxFreq = freq[ch-'a'];
                maxFreqChar = ch-'a';
            }
        }
        
        if(maxFreq > (n+1)/2) return "";
        
        var ans = new char[n];
        int idx = 0;
        while(freq[maxFreqChar] > 0){
            ans[idx] = (char)(maxFreqChar+'a');
            idx += 2;
            freq[maxFreqChar]--;
        }
        
        for(int i = 0; i < 26; i++){
            while(freq[i] > 0){
                if(idx >= n) idx = 1;
                ans[idx] = (char)(i+'a');
                idx += 2;
                freq[i]--;
            }
        }
        
        return String.valueOf(ans);
    }
}