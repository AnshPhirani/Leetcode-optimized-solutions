class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] freq = new int[26];
        for(String word : words){
            for(char ch : word.toCharArray()) freq[ch-'a']++;
        }
        
        for(int f : freq) if(f%n != 0) return false;
        return true;
    }
}