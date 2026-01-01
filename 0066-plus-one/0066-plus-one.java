class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--){
            int digit = digits[i];
            ans.add((digit+carry)%10);
            carry = (digit+carry)/10;
        }
        if(carry > 0) ans.add(carry);
        
        int[] arr = new int[ans.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = ans.get(arr.length-1-i);
        }
        return arr;

    }
}