class Solution {
    
    private int maxConsecutiveChar(String str, int k, char ch){
        int res = 0;
        int s = 0;
        int operationCount = 0;
        for(int e = 0; e < str.length(); e++){
            char cur = str.charAt(e);
            if(cur != ch) operationCount++; 
            while(operationCount > k){
                if(str.charAt(s++) != ch) operationCount--;
            }
            res = Math.max(res, e-s+1);
        }
        return res;
    }
    
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxT = maxConsecutiveChar(answerKey, k, 'T');
        int maxF = maxConsecutiveChar(answerKey, k, 'F');
        return Math.max(maxT, maxF);
    }
}