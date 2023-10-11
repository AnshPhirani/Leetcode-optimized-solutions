class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for(int[] flower : flowers){
            starts.add(flower[0]);
            ends.add(flower[1]+1);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        
        int n = people.length;
        int[][] updatedPeople = new int[n][2];
        for(int i = 0; i < n; i ++){
            updatedPeople[i][0] = people[i];
            updatedPeople[i][1] = i;
        }
        Arrays.sort(updatedPeople, (a, b) -> a[0]-b[0]);
        
        int[] ans = new int[n];
        int startIdx = 0, endIdx = 0;
        int curFullBloom = 0;
        for(int i = 0; i < n; i++){
            int curTime = updatedPeople[i][0];
            int peopleIdx = updatedPeople[i][1];
            while(startIdx < starts.size() && starts.get(startIdx) <= curTime){
                curFullBloom++;
                startIdx++;
            }
            while(endIdx < ends.size() && ends.get(endIdx) <= curTime){
                curFullBloom--;
                endIdx++;
            }
            ans[peopleIdx] = curFullBloom;
        }
        
        return ans;
        
    }
}