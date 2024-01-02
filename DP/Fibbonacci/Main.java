class Main{
    public static void main(String[] args) {
        int input = 4;
        int[] dp = new int[input+1];
        System.out.println(solve(input,dp));
    }
    public static int solve(int i, int[] dp){
        // 1. base case
        if(i <= 1 ) return 1;

        // 2. check on dp table
        if(dp[i] != 0) return dp[i];

        // 3. calculate nd store on dp table
        dp[i] = solve(i-1, dp) + solve(i-2, dp);

        return dp[i];
    }
}