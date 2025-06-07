class Solution {
    public String clearStars(String s) {
        int n = s.length();

        boolean[] removed = new boolean[n];
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() != b.getKey() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);
            if(ch == '*'){
                int minIdx = pq.poll().getValue();
                removed[minIdx] = true;
                removed[idx] = true;
            }
            else{
                pq.add(new Pair(ch, idx));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < n; idx++) if(!removed[idx]) sb.append(s.charAt(idx));
        return sb.toString();

    }
}
