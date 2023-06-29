class Solution {
    
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        
        Map<Character, Integer> keyMap = new HashMap<>();
        
        int[] start = {};
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = grid[i].charAt(j);
                if(Character.isLowerCase(ch)) keyMap.put(ch, k++);
                if(ch == '@') start = new int[]{i, j, 0};
            }
        }
        
        int stateEnd = (1<<k)-1;
        
        boolean[][][] visited = new boolean[n][m][1<<k];

        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        
        int level = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] cur = que.poll();
                int x = cur[0], y = cur[1], state = cur[2];
                if(x < 0 || y < 0 || x >= n || y >= m || grid[x].charAt(y) == '#') continue;
                
                char ch = grid[x].charAt(y);
                if(Character.isUpperCase(ch)){
                    int keyBit = keyMap.get(Character.toLowerCase(ch));
                    if((state & 1<<keyBit) == 0) continue; // key not present
                }
                if(Character.isLowerCase(ch)){
                    int keyBit = keyMap.get(Character.toLowerCase(ch));
                    state = state | (1<<keyBit);
                }

                if(state == stateEnd) return level;
                if(visited[x][y][state]) continue;
                visited[x][y][state] = true;
                
                for(int[] d : dir){
                    que.add(new int[]{x+d[0], y+d[1], state});
                }
            }
            level++;
        }
    
        return -1; 
    }
}

