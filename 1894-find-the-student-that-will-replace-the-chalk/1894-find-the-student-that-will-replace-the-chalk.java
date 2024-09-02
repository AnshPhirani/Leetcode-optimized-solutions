class Solution {
    public int chalkReplacer(int[] chalk, long k) {
        long sum = 0;
        for(int c : chalk) sum += c;
        k = k%sum;
        
        for(int i = 0; i < chalk.length; i++){
            k -= chalk[i];
            if(k < 0) return i;
        }
        
        return -1;
    }
}