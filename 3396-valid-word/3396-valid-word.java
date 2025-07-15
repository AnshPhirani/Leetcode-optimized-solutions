class Solution {
    public boolean isValid(String word) {

        if(word.length() < 3) return false;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        boolean hasVowel = false, hasConsonent = false;
        for(char ch : word.toCharArray()){
            if(!Character.isDigit(ch) && !Character.isLetter(ch)) return false;
            if(Character.isLetter(ch)){
                if(vowels.contains(Character.toLowerCase(ch))){
                    hasVowel = true;
                }
                else{
                    hasConsonent = true;
                }
            }
        }

        return hasVowel && hasConsonent;

    }
}