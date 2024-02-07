import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] row : dp){
            for(int[] r : row){
                Arrays.fill(r,-1);
            }

        }
        System.out.println(solve(prices, 0, 1, 2, dp));
    }
    public static int solve(int[] prices,int i,int canBuy, int limit ,int[][][] dp){

        if(i == prices.length) return 0;
        if(limit == 0) return 0;

        if(dp[i][canBuy][limit] != -1) return dp[i][canBuy][limit];

        int ansProfit = 0;

        if(canBuy == 1){
            //do buy
            int case1 = -prices[i] + solve(prices, i+1, 0,limit,dp);
            //skip
            int case2 = 0 + solve(prices, i+1, 1,limit,dp);

            ansProfit += Math.max(case2, case1);
        }else{
            //do sell
            int case1 = +prices[i] + solve(prices, i+1, 1,limit-1,dp);
            
            //skip
            int case2 = 0 + solve(prices, i+1, 0,limit,dp);

            ansProfit += Math.max(case2, case1);
        }
        dp[i][canBuy][limit] = ansProfit;
        return ansProfit;
    }
}
