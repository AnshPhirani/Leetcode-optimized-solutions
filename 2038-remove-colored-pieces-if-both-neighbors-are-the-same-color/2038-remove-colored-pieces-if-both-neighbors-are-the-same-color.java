class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceOptions = 0, bobOptions = 0;
        
        int count = 0;
        int curColor = colors.charAt(0);
        for(char color : colors.toCharArray()){
            if(color == curColor){
                count++;
            }
            else{
                if(curColor == 'A') aliceOptions += Math.max(0, count-2);
                else bobOptions += Math.max(0, count-2);
                curColor = color;
                count = 1;
            }
        }
        
        if(curColor == 'A') aliceOptions += Math.max(0, count-2);
        else bobOptions += Math.max(0, count-2);
        
        return (aliceOptions > bobOptions)? true : false; 
        
    }
}