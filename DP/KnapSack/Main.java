import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        int[] weight = {1, 2, 4, 5};
        int[] value =  {5, 4, 8, 6};
        int capacity = 5;
        int[][] dp = new int[value.length][capacity+1];
        for (int[] row: dp)
        Arrays.fill(row, -1);
        int ans = solve(weight, value, value.length - 1, capacity,dp, -1);
        System.out.println(ans);
    }
    public static int solve(int[] weight, int[] value, int n, int maxWeight ,int[][] dp, int maxAns){
        if(n == 0){
            if(maxWeight >= weight[0]){
                return value[0];
            }else{
                return 0;
            }
        }

        if(dp[n][maxWeight] != -1) return dp[n][maxWeight];

        int incl = 0;
        if(maxWeight >= weight[n])
        incl = value[n] + solve(weight, value, n-1, maxWeight - weight[n], dp , maxAns);
        int excl = 0 + solve(weight, value, n-1, maxWeight, dp, maxAns);

        dp[n][maxWeight] = Math.max(incl, excl);
        maxAns = Math.max(maxAns,dp[n][maxWeight]);
        return dp[n][maxWeight];

    }
}