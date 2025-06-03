class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        Set<Integer> boxes = new HashSet<>();
        for(int initialBox : initialBoxes) boxes.add(initialBox);

        Queue<Integer> que = new LinkedList<>();
        for(int initialBox : initialBoxes) {
            if(status[initialBox] == 1) {
                que.add(initialBox);
                status[initialBox] = -1; // opened/visited
            }
            
        }

        int candiesCount = 0;
        while(!que.isEmpty()){
            int curBox = que.poll();
            candiesCount += candies[curBox];

            for(int key : keys[curBox]){
                if(status[key] == 0){
                    status[key] = 1;
                    if(boxes.contains(key)){
                        que.add(key);
                        status[key] = -1; // opened/visited
                    }
                }
            }
            for(int containedBox : containedBoxes[curBox]){
                boxes.add(containedBox);
                if(status[containedBox] == 1){
                    que.add(containedBox);
                    status[containedBox] = -1; // opened/visited
                }
            }
        }

        return candiesCount;
    }
}