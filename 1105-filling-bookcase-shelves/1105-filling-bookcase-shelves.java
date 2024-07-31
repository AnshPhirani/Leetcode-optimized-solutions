class Solution {
    Integer[][] memo ;
    
    private int dfs(int idx, int curWidth, int curHeight, int[][] books, int shelfWidth){
        if(curWidth > shelfWidth) return 99999999;
        if(idx == books.length) return curHeight;
        
        if(memo[idx][curWidth] != null)  return memo[idx][curWidth];
        
        
        int w = books[idx][0], h = books[idx][1];  
        int curMinHeight = 99999999;
        
        // add in same row
        curMinHeight = Math.min(curMinHeight, dfs(idx+1, curWidth+w, Math.max(curHeight, h), books, shelfWidth));
        
        // move to next row
        curMinHeight = Math.min(curMinHeight, curHeight + dfs(idx+1, w, h, books, shelfWidth));
        
        return memo[idx][curWidth] = curMinHeight;
    }
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.memo = new Integer[books.length][shelfWidth+1];
        return dfs(0, 0, 0, books, shelfWidth);
    }
}