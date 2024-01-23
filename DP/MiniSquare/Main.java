import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 100;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(solve(n,dp));
    }

    public static int solve(int n, int[] dp){
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            int remain = n - (i*i);
            min = Math.min(solve(remain,dp)+1, min);
        }
        dp[n] = min;
        return dp[n];
    }
    
}
