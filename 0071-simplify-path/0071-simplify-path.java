class Solution {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        
        Stack<String> st = new Stack<>();
        for(String cur : pathArray){
            if(cur.equals("") || cur.equals(".")){
                continue;
            }
            else if(cur.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(cur);
            }
        }
        
        if(st.isEmpty()) return "/";
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, "/"+st.pop());
        }
        
        return sb.toString();
    }
}