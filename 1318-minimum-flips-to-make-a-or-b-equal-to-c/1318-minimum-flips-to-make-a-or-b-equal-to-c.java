class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        int pos = 0;
        while((a|b) != c){
            int firstBit = (a>>pos)%2 == 0? 0 : 1;
            int secondBit = (b>>pos)%2 == 0? 0 : 1;
            int thirdBit = (c>>pos)%2 == 0? 0 : 1;
            if((firstBit | secondBit) == thirdBit){
                pos++;
                continue;
            }
            
            if(thirdBit == 1){
                flips++;
                a |= 1<<pos;
            }
            else{
                if(firstBit == 1){
                    flips++;
                    a &= ~(1<<pos);
                }
                if(secondBit == 1){
                    flips++;
                    b &= ~(1<<pos);
                }
            }
            pos++;
        }
        
        return flips;
    }
}