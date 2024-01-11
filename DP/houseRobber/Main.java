import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] inputs = { 2,7,9,3,1 };
        int[] dp = new int[inputs.length];
        Arrays.fill(dp, -1);
        int ans = solve(inputs, inputs.length - 1, dp);
        System.out.println(ans);
    }
    public static int solve(int[] nums,int i, int[] dp) {
        if(i < 0) return 0;
        if(i == 0) return nums[0];

        if(dp[i] != -1) return dp[i];

        int incl = solve(nums, i-2, dp) + nums[i];
        int excl = solve(nums, i-1, dp) + 0;

        dp[i] = Math.max(incl, excl);

        return dp[i];
    }
}
