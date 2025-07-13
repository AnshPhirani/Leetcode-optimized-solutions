class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int k = 0;
        int count = 0;
        for(int idx = 0; idx < trainers.length; idx++){
            if(k < players.length && players[k] <= trainers[idx]){
                k++;
                count++;
            }
        }

        return count;
    }
}