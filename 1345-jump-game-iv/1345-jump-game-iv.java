class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int val = arr[i];
            map.putIfAbsent(val, new HashSet<>());
            map.get(val).add(i);
        }
        
        
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        
        que.add(0);
        visited[0] = true;
        int steps = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int curPos = que.poll();
                if(curPos == n-1) return steps;
                
                if(curPos-1 >= 0 && !visited[curPos-1]){
                    que.add(curPos-1);
                    visited[curPos-1] = true;
                }
                if(curPos+1 < n && !visited[curPos+1]){
                    que.add(curPos+1);
                    visited[curPos+1] = true;
                }
  
                for(int sameValuePos : map.get(arr[curPos])){
                    if(!visited[sameValuePos]) {
                        que.add(sameValuePos);
                        visited[sameValuePos] = true;
                    }
                }
                map.get(arr[curPos]).clear(); //  stop repeative work
            }
            steps++;
        }
        
        return -1; //  never reached
        
    }
}