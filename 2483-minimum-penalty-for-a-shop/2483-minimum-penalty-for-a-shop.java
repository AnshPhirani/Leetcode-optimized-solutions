class Solution {
    public int bestClosingTime(String customers) {
        int suffixY = 0;
        for(char ch : customers.toCharArray())
            suffixY += ch=='Y' ? 1 : 0;
        
        int minPenalty = Integer.MAX_VALUE;
        int ans = 0;
        
        int prefixN = 0;
        for(int i = 0; i < customers.length(); i++){
            char ch = customers.charAt(i);
            int curPenalty = prefixN + suffixY;
            if(curPenalty < minPenalty){
                minPenalty = curPenalty;
                ans = i;
            }
            if(ch == 'Y') suffixY--;
            else prefixN++;
        }
        
        int curPenalty = prefixN + suffixY;
        if(curPenalty < minPenalty){
            minPenalty = curPenalty;
            ans = customers.length();
        }
        
        return ans;
        
    }
}