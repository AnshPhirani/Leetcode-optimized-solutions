class Solution {
//     public long minEnd(int n, int x) {
//         if(n == 1) return x;
        
//         List<Integer> zeroPos = new ArrayList<>();
//         int pos = 0;
//         int val = x;
//         while(val > 0){
//             if((val&1) == 0) zeroPos.add(pos);
//             pos++;
//             val >>= 1;
//         }
        
//         int reqBits = (int)Math.ceil(Math.log(n)/Math.log(2));
//         while(zeroPos.size() < reqBits){
//             zeroPos.add(pos);
//             pos++;
//         }
        
//         String bitToAppend = Integer.toBinaryString(n-1);
//         System.out.println(reqBits == bitToAppend);
        
//         long ans = x;
//         int posIdx = 0;
        
//         for(int i = bitToAppend.length()-1; i >= 0; i--){
//             if(bitToAppend)
//         }
        
        
        
//         return ans;
//     }
    
    public long minEnd(int n, int x) {
        long a = x;
        while (--n > 0)
            a = (a + 1) | x;
        return a;
    }
}


// 100

// 100
// 101
// 110
// 111
    
    
// 0000101
// 0000111
// 0001101
