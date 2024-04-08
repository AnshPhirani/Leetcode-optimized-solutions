class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circle = 0, square = 0;
        for(int prefers : students){
            if(prefers == 0) circle++;
            else square++;
        }
        
        for(int i = 0; i < sandwiches.length; i++){
            int sandwich = sandwiches[i];
            if(sandwich == 0 && circle > 0) circle--;
            else if(sandwich == 1 && square > 0) square--;
            else return sandwiches.length-i;
        }
        
        return 0;        
        
    }
}