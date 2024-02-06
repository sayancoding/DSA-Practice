import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4};
        int[] prices = {1,2,3,4,5};
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        
        System.out.println(solve(prices, 0, 1,dp));
    }
    public static int solve(int[] prices,int i,int canBuy ,int[][] dp){

        if(i == prices.length) return 0;

        if(dp[i][canBuy] != -1) return dp[i][canBuy];

        int ansProfit = 0;

        if(canBuy == 1){
            //do buy
            int case1 = -prices[i] + solve(prices, i+1, 0,dp);
            //skip
            int case2 = 0 + solve(prices, i+1, 1,dp);

            ansProfit += Math.max(case2, case1);
        }else{
            //do sell
            int case1 = +prices[i] + solve(prices, i+1, 1,dp);
            
            //skip
            int case2 = 0 + solve(prices, i+1, 0,dp);

            ansProfit += Math.max(case2, case1);
        }
        dp[i][canBuy] = ansProfit;
        return ansProfit;
    }
}
