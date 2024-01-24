import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] satisfaction = {-1,-4,-5};
        System.out.println(maxSatisfaction(satisfaction));
    }
    public static int maxSatisfaction(int[] satisfaction) {
        int[][] dp = new int[satisfaction.length+1][satisfaction.length+1];
        for(int[] row : dp){ Arrays.fill(row, -1);}
        Arrays.sort(satisfaction);
        int ans = solve(satisfaction, 0, 1,dp);
        return ans < 0 ? 0 : ans;
    }
    public static int solve(int[] satisfaction, int i, int order, int[][] dp){
        if(i == satisfaction.length) return 0;

        if(dp[i][order] != -1) return dp[i][order];
        
        //include
        int include = (order * satisfaction[i]) + solve(satisfaction, i+1, order+1,dp);
        //exclude
        int exclude = solve(satisfaction, i+1, order,dp);

        dp[i][order] = Math.max(include, exclude);
        
        return dp[i][order];
    }
}
