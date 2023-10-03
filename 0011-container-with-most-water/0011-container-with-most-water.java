class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int ans = 0;
        while(left < right){
            int leftHeight = height[left];
            int rightHeight = height[right];
            int curArea = (right-left)*Math.min(leftHeight, rightHeight);
            ans = Math.max(ans, curArea);
            if(leftHeight < rightHeight) left++;
            else right--;
        }
        return ans;
    }
}