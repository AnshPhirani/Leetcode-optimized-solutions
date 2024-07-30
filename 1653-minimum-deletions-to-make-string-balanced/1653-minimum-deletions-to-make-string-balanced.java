class Solution {
    public int minimumDeletions(String str) {
        int n = str.length();
        int leftBCount = 0;
        int rightACount = 0;
        
        for(char ch : str.toCharArray()) 
            if(ch == 'a') rightACount++;
        
        int ans = n;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, leftBCount + rightACount);
            if(str.charAt(i) == 'b') leftBCount++;
            else rightACount--;
        }
        ans = Math.min(ans, leftBCount + rightACount);
        
        return ans;
     
    }
}