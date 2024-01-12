class Solution {
    public boolean halvesAreAlike(String s) {
        int vowels = 0;
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowels += (i >= s.length()/2) ? -1 : 1;
            }
        }
        return vowels == 0;
    }
}