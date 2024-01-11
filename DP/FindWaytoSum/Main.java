import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] num = {1,2,5};
        int tar = 5;
        int[] dp = new int[tar+1];
        Arrays.fill(dp, -1);
        System.out.println(findWays(num, tar,dp));
    }
    public static int findWays(int num[], int tar, int[] dp) {
        if(tar == 0){
            return 1;
        }
        if(tar < 0){
            return 0;
        }

        if(dp[tar] != -1) return dp[tar];
        
        int ans = 0;
        for(int j = 0; j< num.length; j++){
            if(num[j] <= tar){
                ans = ans + findWays(num, tar - num[j] , dp);
            }
        }
        dp[tar] = ans;
        return dp[tar];
    }
}
