class Solution {
     List<String> res;
    
    private void helper(int idx, String s, String curIp, int dots){
        if(idx == s.length()){
            if(dots == 4) res.add(curIp.substring(0,curIp.length()-1));
            return;
        }
        // System.out.println(curIp);
        
        int n = s.length();
        
        if(s.charAt(idx) == '0'){
            helper(idx+1, s, curIp+s.charAt(idx)+'.', dots+1);
        }
        else{
            int curPart = s.charAt(idx) - '0';
            
            helper(idx+1, s, curIp+curPart+'.', dots+1);

            if(idx+1 < n){
                curPart *= 10;
                curPart += s.charAt(idx+1) - '0';
                helper(idx+2, s, curIp+curPart+'.', dots+1);
            }
            if(idx+2 < n){
                curPart *= 10;
                curPart += s.charAt(idx+2) - '0';
                if(curPart >= 0 && curPart <= 255)
                    helper(idx+3, s, curIp+curPart+'.', dots+1);
            }
        }
        
    }
    
    public List<String> restoreIpAddresses(String s) {        
        res = new ArrayList<>();
        if(s.length() > 12) return res; // not possible
        
        helper(0, s, "", 0);
        return res;
    }
}