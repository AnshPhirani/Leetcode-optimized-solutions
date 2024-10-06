class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() > sentence2.length())
            return areSentencesSimilar(sentence2, sentence1);
        
        String[] smaller = sentence1.split(" ");
        String[] larger = sentence2.split(" ");
        
        int start = 0;
        while(start < smaller.length){
            if(!smaller[start].equals(larger[start])) break;
            start++;
        }
        
        int end = smaller.length-1;
        int end2 = larger.length-1;
        while(end >= start){
            if(!smaller[end].equals(larger[end2])) break;
            end--;
            end2--;
        }
        
       return end < start;
        
    }
}