class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        
        int[] count = new int[3];
        for(char ch : s.toCharArray()) count[ch-'a']++;
        
        for(int c : count) if(c < k) return -1;
        
        int[] windowCount = new int[3];
        int maxWindow = 0;
        int left = 0, right = 0;
        while(right < n){
            char ch = s.charAt(right);
            windowCount[ch-'a']++;
            while(left <= right && (count[0] - windowCount[0] < k || count[1] - windowCount[1] < k || count[2] - windowCount[2] < k )){
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }
            
            maxWindow = Math.max(maxWindow, right-left+1);
            right++;   
        }
        
        
       
        return n-maxWindow;
    }
}