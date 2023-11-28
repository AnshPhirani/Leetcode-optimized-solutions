class Solution {
    public int numberOfWays(String corridor) {
        int totalSeats = 0;
        int prevSeat = 0;
        long res = 1;
        
        for(int i = 0; i < corridor.length(); i++){
            char ch = corridor.charAt(i);
            if(ch == 'S'){
                totalSeats++;
                if(totalSeats > 2 && totalSeats%2 == 1){
                    res *= (i-prevSeat);
                    res %= (int)1e9+7;
                }
                prevSeat = i;
            }
        }
        
        return totalSeats > 1 && totalSeats%2 == 0 ? (int)res : 0;
        
    }
}