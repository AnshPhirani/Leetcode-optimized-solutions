/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    
    private int gridSum(int topLeftR, int topLeftC, int bottomRightR, int bottomRightC, int[][] grid){
        int sum = 0;
        for(int i = topLeftR; i <= bottomRightR; i++){
            for(int j = topLeftC; j <= bottomRightC; j++){
                sum += grid[i][j];
            }
        }
        return sum;
    }
    
    private Node helper(int topLeftR, int topLeftC, int bottomRightR, int bottomRightC, int[][] grid){
        
        int gridSum = gridSum(topLeftR, topLeftC, bottomRightR, bottomRightC, grid);
  
        if(gridSum == 0) return new Node(false, true);
        if(gridSum == (bottomRightR-topLeftR+1)*(bottomRightC-topLeftC+1)) return new Node(true, true);
        
        int midR = (topLeftR + bottomRightR)/2;
        int midC = (topLeftC + bottomRightC)/2;
        
        Node curParent = new Node(false, false);
        curParent.topLeft = helper(topLeftR, topLeftC, midR, midC, grid);
        curParent.topRight = helper(topLeftR, midC+1, midR, bottomRightC, grid);
        curParent.bottomLeft = helper(midR+1, topLeftC, bottomRightR, midC, grid);
        curParent.bottomRight = helper(midR+1, midC+1, bottomRightR, bottomRightC, grid);
        
        return curParent;
    }
    
    
    public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(0, 0, n-1, n-1, grid);
    }
}