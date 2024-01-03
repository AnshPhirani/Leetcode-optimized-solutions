class Solution {
    public int numberOfBeams(String[] bank) {
        int beamCount = 0;
        int prevDevices = 0;
        for(String b : bank){
            int curDevices = 0; 
            for(char ch : b.toCharArray()){
                if(ch == '1') curDevices++;
            }
            if(curDevices > 0){
                beamCount += prevDevices*curDevices;
                prevDevices = curDevices;
            }
        }
        
        return beamCount;
    }
}