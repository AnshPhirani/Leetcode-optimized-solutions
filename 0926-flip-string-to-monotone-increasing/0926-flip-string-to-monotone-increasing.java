class Solution {
    
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        
        int prefixOnes = 0;
        int sufixZeros = 0;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                sufixZeros++;   
            }
        }
        
        int minFlips = n;
        for(int i = 0; i < n; i++){
            minFlips = Math.min(minFlips, prefixOnes+sufixZeros);
            if(s.charAt(i) == '1') prefixOnes++;
            else sufixZeros--;
        }
        minFlips = Math.min(minFlips, prefixOnes); // all zeros case
        
        return minFlips;
    }
}