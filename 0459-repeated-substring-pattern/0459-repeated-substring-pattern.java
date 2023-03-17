class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = 1; i <= n/2; i++){
            if(n%i != 0) continue;
            String substr = s.substring(0,i);
            System.out.println(substr);
            StringBuilder sb = new StringBuilder();
            int j = 1;
            for(; j < n/i; j++){
                if(!substr.equals(s.substring(j*i, j*i + i))) break;
            }
            if(j == n/i) return true;
        }
        return false;
    }
}