class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for(String op : operations){
            if(op.charAt(0) == '+' || op.charAt(2) == '+') val++;
            if(op.charAt(0) == '-' || op.charAt(2) == '-') val--;
        }
        return val;
    }
}