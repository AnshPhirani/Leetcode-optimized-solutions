class Solution {
    public String convertToTitle(int columnNumber) {
        if(columnNumber == 0) return "";
        if(columnNumber <= 26){
            return "" + (char)('A' + columnNumber-1);
        }
        
        String cur = columnNumber%26 == 0 ? "Z" : "" + (char)('A' + columnNumber%26 - 1);
        int remaining = columnNumber%26 == 0 ? columnNumber/26 - 1 : columnNumber/26;
        return convertToTitle(remaining) + cur;
        
    }
}