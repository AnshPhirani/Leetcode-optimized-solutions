class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder res = new StringBuilder();
        
        int i = a.length()-1, j = b.length()-1;
        
        while(i >= 0 || j >= 0 || carry == 1){
            int first = (i >= 0) ? a.charAt(i)-'0' : 0;
            int second = (j >= 0) ? b.charAt(j)-'0' : 0;
            
            int sum = first+second+carry;
            res.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        
        return res.reverse().toString();
    }
}