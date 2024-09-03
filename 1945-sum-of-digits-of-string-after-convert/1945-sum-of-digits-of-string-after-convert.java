class Solution {
    public int getLucky(String s, int k) {
        String num = "";
        for(char ch : s.toCharArray()){
            num += (ch-'a' + 1);
        }
        
        int res = 0;
        while(k-- > 0){
            res = 0;
            for(char ch : num.toCharArray()) res += (ch-'0');
            num = String.valueOf(res);
            System.out.println(res);
        }
        return res;
    }
}