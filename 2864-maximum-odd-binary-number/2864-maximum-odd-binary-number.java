class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int oneCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1') oneCount++;
        }
        
        StringBuilder res = new StringBuilder();
        while(oneCount > 1){
            res.append('1');
            oneCount--;
        }
        while(res.length() < n-1){
            res.append('0');
        }
        
        res.append('1');
        return res.toString();   
    }
}