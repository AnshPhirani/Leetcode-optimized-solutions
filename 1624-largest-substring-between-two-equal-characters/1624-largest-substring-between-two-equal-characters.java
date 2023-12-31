class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstOccurence = new int[26];
        Arrays.fill(firstOccurence, -1);
        int ans = -1;
        for(int i = 0; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(firstOccurence[ch-'a'] != -1){
                ans = Math.max(ans, i-firstOccurence[ch-'a']-1);
            }
            else{
                firstOccurence[ch-'a'] = i;
            }
        }
        return ans;
    }
}