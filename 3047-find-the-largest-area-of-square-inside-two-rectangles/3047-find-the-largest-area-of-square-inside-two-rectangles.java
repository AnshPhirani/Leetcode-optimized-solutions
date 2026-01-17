class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;

        long ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(bottomLeft[i][0] > topRight[j][0] || bottomLeft[j][0] > topRight[i][0]){
                    continue;
                }
                if(bottomLeft[i][1] > topRight[j][1] || bottomLeft[j][1] > topRight[i][1]){
                    continue;
                }  

                // when rectangles intersect, find the intersect and max square we can form is the small side of the intersecting rectangle
                int bottomX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int bottomY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int topX = Math.min(topRight[i][0], topRight[j][0]);
                int topY = Math.min(topRight[i][1], topRight[j][1]);
                ans = Math.max(ans, Math.min(Math.abs(topX-bottomX), Math.abs(topY-bottomY)));
            }
        }

        return ans * ans;

    }
}