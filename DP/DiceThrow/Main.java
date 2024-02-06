import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(noOfWays(6, 3, 12));
    }
    static long noOfWays(int M , int N , int X) {
        long[][] dp = new long[N+1][X+1];
        for(long[] row : dp) Arrays.fill(row, -1);
        return solve(N, M, X, dp);
    }
    static long solve(int dice, int side, int target, long[][] dp){
        if(target == 0 && dice == 0){
            return 1;
        }

        if(dice == 0 || target < 0){
            return 0;
        }

        if(dp[dice][target] != -1) return dp[dice][target];

        long way = 0;
        for(int i = 1; i <= side; i++){
            way += solve(dice-1, side, target-i,dp);
        }

        dp[dice][target] = way;

        return dp[dice][target];

    }
}
