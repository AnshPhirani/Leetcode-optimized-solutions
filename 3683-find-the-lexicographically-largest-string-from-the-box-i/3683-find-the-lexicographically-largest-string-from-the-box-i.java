class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if(numFriends == 1) return word;
        int substringLength = n-(numFriends-1);



        String lexLargestSplit = "";
        for(int idx = 0; idx < n; idx++){
            String curSplit = word.substring(idx, Math.min(n, idx+substringLength));
            // System.out.println(curSplit);
            if(lexLargestSplit.compareTo(curSplit) < 0) lexLargestSplit = curSplit;
        }

        return lexLargestSplit;

    }
}