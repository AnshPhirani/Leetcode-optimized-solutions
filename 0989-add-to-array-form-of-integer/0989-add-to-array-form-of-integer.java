class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        
        int n = num.length-1;
        int carry = 0;
        
        while(n >= 0 || k > 0 || carry > 0){
            int first = (n >= 0) ? num[n] : 0;
            int second = (k > 0) ? k%10 : 0;
            int sum = first+second+carry;
            res.add(sum%10);
            carry = sum/10;
            
            n--;
            k/=10;
        }
        
        Collections.reverse(res);
        return res;
        
    }
}