import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] cuts = {3,3,3};
        int target = 8;
        int[] dp = new int[target + 1];
        Arrays.fill(dp , -1);
        int ans = solve(cuts, target, dp);
        if(ans == Integer.MIN_VALUE) ans = 0;
        System.out.println(ans);
    }
    public static int solve(int[] cut, int target,int[] dp){
        if(target == 0) return 0;

        if(dp[target] != -1) return dp[target];

        int maxAns = Integer.MIN_VALUE;
        for (int i = 0; i < cut.length; i++) {
            if(cut[i] <= target){
                int subAns = solve(cut, target - cut[i], dp);
                if(subAns != Integer.MIN_VALUE && subAns + 1 > maxAns){
                    maxAns = subAns + 1;
                }
                dp[target] = maxAns;
            }
        }

        return maxAns;
    }
}
