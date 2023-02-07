class Solution {
    public int totalFruit(int[] fruits) {
        int firstType = -1, secondType = -1;
        int firstCount = 0, secondCount = 0;
        int maxCount = 0;
        
        int start = 0;
        for(int end = 0; end < fruits.length; end++){
            while(fruits[end] != firstType && fruits[end] != secondType && firstType != -1 && secondType != -1){
                if(fruits[start] == firstType){
                    firstCount--;
                    if(firstCount == 0){
                        firstType = fruits[end];
                        break;
                    }
                }
                
                if(fruits[start] == secondType){
                    secondCount--;
                    if(secondCount == 0){
                        secondType = fruits[end];
                        break;
                    }
                }
                start++;
            }
            
            if(firstType == -1) firstType = fruits[end];
            else if(fruits[end] != firstType && secondType == -1) secondType = fruits[end];
            
            if(fruits[end] == firstType){
                firstCount++;
            }
            else if(fruits[end] == secondType){
                secondCount++;
            }
          
      
            maxCount = Math.max(maxCount, firstCount+secondCount);
        }
        
        return maxCount;
    }
}