class Solution {
    public int minMaxDifference(int num) {
        String n = String.valueOf(num);
        char[] arr = n.toCharArray();

        int max = 0, min = 0;
        int maxReplace = -1, minReplace = -1;   
        for(int idx = 0; idx < arr.length; idx++){
            if(arr[idx] < '9' && maxReplace == -1){
                maxReplace = arr[idx]-'0';
            }
            if(arr[idx] > '0' && minReplace == -1){
                minReplace = arr[idx]-'0';
            }

            max = (maxReplace == arr[idx]-'0') ? max*10+9 : max*10+(arr[idx]-'0');
            min = (minReplace == arr[idx]-'0') ? min*10+0 : min*10+(arr[idx]-'0');
        }
        // System.out.println(max + " " + min);
        return max-min;
    }
}