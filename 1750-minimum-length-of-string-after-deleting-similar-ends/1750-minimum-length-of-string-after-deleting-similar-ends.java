class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length()-1;
        while(l < r){
            char first = s.charAt(l), last = s.charAt(r);
            if(first != last) break;
            while(l <= r && s.charAt(l) == first) l++;
            while(l <= r && s.charAt(r) == last) r--;
        }
        return r-l+1;
    }
}