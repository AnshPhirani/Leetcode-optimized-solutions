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

    
    private Node helper(int topLeftR, int topLeftC, int bottomRightR, int bottomRightC, int[][] grid){
        
        if(topLeftR == bottomRightR && topLeftC == bottomRightC){
            return new Node(grid[topLeftR][topLeftC] == 1, true);
        }
        
        int midR = (topLeftR + bottomRightR)/2;
        int midC = (topLeftC + bottomRightC)/2;

        Node topLeft = helper(topLeftR, topLeftC, midR, midC, grid);
        Node topRight = helper(topLeftR, midC+1, midR, bottomRightC, grid);
        Node bottomLeft = helper(midR+1, topLeftC, bottomRightR, midC, grid);
        Node bottomRight = helper(midR+1, midC+1, bottomRightR, bottomRightC, grid);
        
        boolean allLeaf = false;
        boolean allSameValue = false;
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val){
            return new Node(topLeft.val, true);
        }
        
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    
    
    public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(0, 0, n-1, n-1, grid);
    }
}