import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] values = {1,2,3};
        System.out.println(minScoreTriangulation(values));
    }
    public static int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length+1][values.length+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(values, 0, values.length-1, dp);
    }
    public static int solve(int[] values, int i, int j,int[][] dp){
        if(i+1 >= j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for(int k = i+1 ; k<j ; k++){
            int subAns = values[i]*values[k]*values[j] + 
                            solve(values, i, k, dp) + solve(values, k, j, dp);
            ans = Math.min(ans, subAns);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
