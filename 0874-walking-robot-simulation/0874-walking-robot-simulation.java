class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> obs = new HashMap<>();
        for(int[] o : obstacles){
            obs.putIfAbsent(o[0], new HashSet<>());
            obs.get(o[0]).add(o[1]);
        }
        
        int maxDist = 0;
        int x = 0, y = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curDir = 0; // North = 0, east = 1, south = 2, west = 3
        for(int command : commands){
            if(command == -1){
                curDir = (curDir+1)%4;
                continue;
            }
            if(command == -2){
                curDir = (curDir-1+4)%4;
                continue;
            }
   
            for(int step = 0; step < command; step++){
                int nextX = x + dir[curDir][0];
                int nextY = y + dir[curDir][1];
                if(obs.containsKey(nextX) && obs.get(nextX).contains(nextY)) 
                    break;
                x = nextX;
                y = nextY;
            }             
            
            maxDist = Math.max(maxDist, x*x + y*y);
        }
        
        return maxDist;
    }
}