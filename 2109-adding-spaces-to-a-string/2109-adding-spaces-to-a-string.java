class Solution {
    public String addSpaces(String s, int[] spaces) {
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(k < spaces.length && i == spaces[k]){
                sb.append(" ");
                k++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}