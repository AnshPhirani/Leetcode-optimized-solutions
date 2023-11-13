class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for(char ch : s.toCharArray()){
            char temp = Character.toLowerCase(ch);
            if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
                vowels.add(ch);
        }
        
        Collections.sort(vowels);
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            char temp = Character.toLowerCase(ch);
            if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u'){
                sb.append(vowels.get(idx));
                idx++;
            }
            else{
                sb.append(ch);    
            }
        }
        
        return sb.toString();
    }
}