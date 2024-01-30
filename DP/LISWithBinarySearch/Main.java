import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] input = {5,8,3,7,9,1};
        int n = input.length;
        System.out.println(lengthOfLIS(input, n));
    }
    public static int lengthOfLIS(int[] nums, int k) {
        int[] dp = new int[k];
        Arrays.fill(dp, -1);
        return solve(nums, 0, new ArrayList<>(),dp);
    }
    public static int solve(int[] nums, int i, List<Integer> subList, int[]dp){
        if( i == nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        int inclu = 0;
        if( subList.size() == 0 || nums[i] > subList.get(subList.size()-1)){
            subList.add(nums[i]);
            inclu = 1 + solve(nums, i+1, subList,dp);
        }

        int exclu = solve(nums, i+1, subList,dp);

        dp[i] = Math.max(inclu, exclu);
        return dp[i];
    }
}
