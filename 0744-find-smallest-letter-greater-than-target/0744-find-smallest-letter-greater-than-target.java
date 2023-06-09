class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length-1;
        int res = 0;
        while(l <= h){
            int mid = (l+h)/2;
            if(letters[mid] > target){
                h = mid-1;
                res = mid;
            }
            else{
                l = mid+1;
            }
        }
        return letters[res];
    }
}