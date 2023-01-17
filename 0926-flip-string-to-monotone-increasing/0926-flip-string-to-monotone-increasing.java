class Solution {
    
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        
        int[] prefixOnes = new int[n+1];
        prefixOnes[0] = 0;
        for(int i = 1; i <= n; i++){
            prefixOnes[i] = prefixOnes[i-1];
            if(s.charAt(i-1) == '1'){
                prefixOnes[i]++;   
            }
        }
        
        int[] sufixZeros = new int[n+1];
        sufixZeros[n] = 0;
        for(int i = n-1; i >= 0; i--){
            sufixZeros[i] = sufixZeros[i+1];
            if(s.charAt(i) == '0'){
                sufixZeros[i]++;   
            }
        }
        
        int minFlips = n;
        for(int i = 0; i <= n; i++){
            int leftOnes = prefixOnes[i];
            int rightZeros = sufixZeros[i];
            minFlips = Math.min(minFlips, leftOnes+rightZeros);
        }
        
        return minFlips;
    }
}