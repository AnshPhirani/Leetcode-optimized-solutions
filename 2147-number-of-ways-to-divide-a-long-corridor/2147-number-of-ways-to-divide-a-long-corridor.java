class Solution {
    public int numberOfWays(String corridor) {
        int totalSeats = 0;
        int curSeats = 0;
        int curPlants = 0;
        long res = 1;
        
        for(char ch : corridor.toCharArray()){
            if(ch == 'S'){
                totalSeats++;
                if(curSeats == 2){
                    res *= (curPlants+1);
                    res %= (int)1e9+7;
                    curPlants = 0;
                    curSeats = 1;
                }
                else{
                    curSeats++;
                }
            }
            else{
                if(curSeats == 2) curPlants++;
            }
        }
        
        return totalSeats%2 != 0 || totalSeats == 0 ? 0 : (int)res;
        
    }
}