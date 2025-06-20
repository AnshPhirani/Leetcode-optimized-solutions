class Solution {
    public int maxDistance(String str, int k) {
        int n = 0, s = 0, e = 0, w = 0;
        int maxDistance = 0;
        for(char ch : str.toCharArray()){
            switch(ch){
                case 'N':
                    n++;
                    break;
                case 'S':
                    s++;
                    break;
                case 'E':
                    e++;
                    break;
                case 'W':
                    w++;
                    break;
            }

            int distance = 0;
            distance += Math.abs(n-s) + 2*Math.min(k, Math.min(n, s));
            int updatedK = k - Math.min(k, Math.min(n, s));
            distance += Math.abs(e-w) + 2*Math.min(updatedK, Math.min(e, w));
            maxDistance = Math.max(maxDistance, distance);
        }

        return maxDistance;
    }
}