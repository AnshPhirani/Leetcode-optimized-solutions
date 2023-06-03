class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> firstMap = new HashMap<>();
        Map<Character, Character> secondMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char first = s.charAt(i);
            char second = t.charAt(i);
            if(!firstMap.containsKey(first) && !secondMap.containsKey(second)){
                firstMap.put(first, second);
                secondMap.put(second, first);
            }
            if(firstMap.getOrDefault(first, '#') != second || secondMap.getOrDefault(second, '#') != first){
                return false;
            }
        }
        
        return true;
    }
}