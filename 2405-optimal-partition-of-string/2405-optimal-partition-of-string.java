class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count = 1;
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                set.clear();
                set.add(ch);
                count++;
            }
            else{
                set.add(ch);
            }
        }
        
        return count;
    }
}