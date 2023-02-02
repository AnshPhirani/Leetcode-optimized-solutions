class Solution {
    
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character, Integer> alienAscii = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            alienAscii.put(ch, i);
        }
        
        for(int i = 1; i < words.length; i++){
            String first = words[i-1];
            String second = words[i];
            boolean flag = false;
            
            for(int j = 0; j < Math.min(first.length(), second.length()); j++){
                int firstAscii = alienAscii.get(first.charAt(j)); 
                int secondAscii = alienAscii.get(second.charAt(j)); 
                if(firstAscii > secondAscii){
                    return false;
                }
                else if(firstAscii < secondAscii){
                    flag = true;
                    break;
                }
            }
            if(!flag && first.length() > second.length()) return false;
        }
        return true;
    }
}