/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][] mat = new int[n][m];
        for(int[] row : mat) Arrays.fill(row, -1);

        int sr = 0, sc = 0, er = n-1, ec = m-1;
        while(head != null){
            for(int j = sc; j <= ec && head != null; j++){
                mat[sr][j] = head.val;
                head = head.next;
            }
            sr++;
            
            for(int i = sr; i <= er && head != null; i++){
                mat[i][ec] = head.val;
                head = head.next;
            }
            ec--;
            
            for(int j = ec; j >= sc && head != null; j--){
                mat[er][j] = head.val;
                head = head.next;
            }
            er--;
            
            for(int i = er; i >= sr && head != null; i--){
                mat[i][sc] = head.val;
                head = head.next;
            }
            sc++;
        }
        
        return mat;
    }
}