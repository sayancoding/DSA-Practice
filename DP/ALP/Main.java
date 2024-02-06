import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 7, 10, 13, 14, 19};
        int ans = lengthOfLongestAP(a, a.length);
        System.out.println(ans);
    }
    public static int lengthOfLongestAP(int[] A,int n) {
        if(n <= 2) return n;
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                int currDiff = A[j] - A[i];
                dp[i].put(currDiff, dp[j].getOrDefault(currDiff, 1)+1);
                ans = Math.max(ans,dp[i].get(currDiff));
            }
        }
        return ans;
    }
    
}
