class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char ch : allowed.toCharArray()) set.add(ch);
        
        int res = 0;
    
        outer:
        for(String word : words){
            for(char ch : word.toCharArray()){
                if(!set.contains(ch)) continue outer;
            }
            res++;
        }
        return res;
    }
}