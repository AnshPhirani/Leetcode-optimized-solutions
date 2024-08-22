class Solution {
    public int findComplement(int num) {
        int pos = 0;
        int comp = 0;
        while(num > 0){
            if((num&1) == 0) comp += 1<<pos;
            pos++;
            num = num>>1;
        }
        return comp;
        
    }
}