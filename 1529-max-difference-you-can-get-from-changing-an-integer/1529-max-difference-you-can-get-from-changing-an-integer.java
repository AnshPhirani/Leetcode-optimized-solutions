class Solution {
    public int maxDiff(int num) {
        String n = String.valueOf(num);
        int max = 0, min = 0;
        int x1 = -1;
        int x2 = n.charAt(0) != '1' ? n.charAt(0)-'0' : -1;
        int y2 = n.charAt(0) != '1' ? 1 : 0;
        for(char ch :n.toCharArray()){
            if(ch != '9' && x1 == -1) x1 = ch-'0';
            if(ch != '1' && ch != '0' && x2 == -1) x2 = ch-'0';
            max = max*10 + ((ch-'0' == x1) ? 9 : ch-'0');
            min = min*10 + ((ch-'0' == x2) ? y2 : ch-'0');
        }
        // System.out.println(max + " " + min);
        return max-min;
    }
}