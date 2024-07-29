class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        
        int[] smallerToRightCount = new int[n];
        int[] largerToRightCount = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(rating[j] < rating[i]) smallerToRightCount[i]++;
                if(rating[j] > rating[i]) largerToRightCount[i]++;
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(rating[i] > rating[j]){
                    ans += smallerToRightCount[j];
                }
                else if(rating[i] < rating[j]){
                    ans += largerToRightCount[j];
                }
            }
        }
        
        return ans;
        
    
        
    }
}