class Solution {
    
    private char helper(String cur, int k){
        if(cur.length() >= k) return cur.charAt(k-1);
        
        String next = cur;
        for(char ch : cur.toCharArray()){
            char newChar = (char)((ch-'a'+1)%26 + 'a');
            next += newChar;
        }
        
        return helper(next, k); 
    }
    
    public char kthCharacter(int k) {
        return helper("a", k);
    }
}



// k = x

// k = 6

// // a   1
// // ab  2
// // abbc  4
// // abbcbccd 8
// // abbcbccdbccdcdde
   
// 1
// 12
// 1223
// 12232334


    