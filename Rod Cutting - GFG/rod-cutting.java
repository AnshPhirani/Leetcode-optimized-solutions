//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    
    Integer[] memo = new Integer[1001];
    
    public int cutRod(int price[], int n) {
        //code here
        if(n == 0) return 0;
        if(n == 1) return price[0];
        
        if(memo[n] != null) return memo[n];
        
        int max = price[n-1];
        for(int i = 0; i < n-1; i++){
            max = Math.max(max, cutRod(price, i+1) + cutRod(price, n-i-1));
        }
        
        return memo[n] = max;
    }
}