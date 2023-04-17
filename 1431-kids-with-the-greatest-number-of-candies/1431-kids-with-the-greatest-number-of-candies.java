class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();
        
        for(int candiesCount : candies){
            if(candiesCount + extraCandies >= maxCandies){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        
        return res;
    }
}