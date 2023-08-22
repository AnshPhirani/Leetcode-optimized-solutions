class Solution {
    public String convertToTitle(int n) {
        System.out.println(n);
        if(n <= 26) return (char)(n + 'A'-1) + "";
        char cur = n%26 == 0 ? 'Z' : (char)(n%26 + 'A'-1);
        int remainingN = n%26 == 0 ? n/26-1 : n/26;
        return convertToTitle(remainingN) + cur;
    }
}