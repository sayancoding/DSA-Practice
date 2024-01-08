import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        int[] coins = {7,5,1};
        int target = 13;
        // int[] coins = {186,419,83,408};
        // int target = 6249;
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int ans = solve(coins, target, dp);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static int solve(int[] coins, int target , int[] dp){
        //base case
        if(target == 0) return dp[0];

        // get from dp table
        if(dp[target] != -1) return dp[target];

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= target){
                int remain = target - coins[i];
                int subAns = solve(coins, remain, dp);

                if(subAns != Integer.MAX_VALUE && subAns+1 < ans){
                    ans = subAns + 1;
                }
            }
        }
        dp[target] = ans;
        return ans;
    }
}