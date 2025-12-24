class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for(int count : apple) totalApples += count;

        List<Integer> capacitySorted = Arrays.stream(capacity).boxed().collect(Collectors.toList());
        Collections.sort(capacitySorted, (a, b) -> b - a);

        int minBoxes = 0;
        for(int cap : capacitySorted){
            if(totalApples <= 0) return minBoxes;
            minBoxes++;
            totalApples -= cap;
        }

        return minBoxes;
    }
}