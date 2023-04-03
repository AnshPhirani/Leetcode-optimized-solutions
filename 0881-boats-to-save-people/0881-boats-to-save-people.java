class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int l = 0;
        int r = n-1;
        int count = 0;
        while(l < r){
            if(people[l] + people[r] <= limit){
                count++;
                l++;
                r--;
            }
            else{
                count++;
                r--;
            }
        }
        if(l == r) count++;
        return count;
    }
}