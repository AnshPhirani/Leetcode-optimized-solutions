class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26];
        for(char ch : word1.toCharArray()) count1[ch-'a']++;
        int[] count2 = new int[26];
        for(char ch : word2.toCharArray()) count2[ch-'a']++;
        
        for(int i = 0; i < 26; i++){
            if((count1[i] == 0 && count2[i] > 0) || (count1[i] > 0 && count2[i] == 0)) return false;
        }
        
        Map<Integer, Integer> freq = new HashMap<>();
        for(int val : count1) freq.put(val, freq.getOrDefault(val, 0)+1);
        
        for(int val : count2){
            if(!freq.containsKey(val)) return false;
            freq.put(val, freq.get(val)-1);
            if(freq.get(val) == 0) freq.remove(val);
        }
        
        return freq.isEmpty();
    }
}