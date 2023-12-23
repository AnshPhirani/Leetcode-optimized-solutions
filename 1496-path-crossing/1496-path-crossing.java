class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();
        visited.add(x+"*"+y);
        for(char ch : path.toCharArray()){
            if(ch == 'N') y++;
            if(ch == 'S') y--;
            if(ch == 'E') x++;
            if(ch == 'W') x--;
            String key = x+"*"+y;
            if(visited.contains(key)) return true;
            visited.add(key);
        }
        return false;
    }
}