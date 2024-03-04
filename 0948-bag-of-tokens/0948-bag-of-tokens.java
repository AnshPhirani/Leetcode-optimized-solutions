class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length-1;
        int curScore = 0, maxScore = 0;;
        while(left <= right){
            if(tokens[left] <= power){
                power -= tokens[left];
                curScore++;
                left++;
            }
            else{
                if(curScore == 0) break;
                power += tokens[right];
                curScore--;
                right--;
            }
            maxScore = Math.max(curScore, maxScore);
        }
        
        return maxScore;
        
    }
}