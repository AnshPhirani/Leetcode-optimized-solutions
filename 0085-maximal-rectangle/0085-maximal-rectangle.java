class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
         if(n == 0){
            return 0;
        }
        int m = matrix[0].length;
        int[] row = new int[m];
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0'){
                    row[j] = 0;
                }
                else{
                    row[j] += 1;
                }
            }
            int curArea = largestRectangleInHistogram(row, m);
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
    
    private int largestRectangleInHistogram(int[] heights, int n){
        Stack<Integer> st = new Stack<>();
        int[] leftLowest = new int[n];
        
        st.push(0);
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                leftLowest[i] = st.peek()+1;
            }
            else{
                leftLowest[i] = 0;
            }
            
            st.push(i);
        }
        System.out.println(Arrays.toString(leftLowest));
        
        st.clear();
        int[] rightLowest = new int[n];
        rightLowest[n-1] = n-1;
        st.push(n-1);
        
         for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rightLowest[i] = st.peek()-1;
            }
            else{
                rightLowest[i] = n-1;
            }
            
            st.push(i);
        }
        
        System.out.println(Arrays.toString(rightLowest));
        
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int height = heights[i];
            int width = rightLowest[i] - leftLowest[i] + 1;
            int curArea = height*width;
            maxArea = Math.max(maxArea, curArea);
        }
        
        return maxArea;
        
    }
    
}