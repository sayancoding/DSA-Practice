import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] inputs = { 2,3,2 };
        
        List<Integer> firstInclude = new ArrayList<>();
        List<Integer> lastInclude = new ArrayList<>();

        for (int i = 0; i < inputs.length; i++) {
            if(i == 0){
                firstInclude.add(inputs[i]);
            }
            else if(i == inputs.length - 1){
                lastInclude.add(inputs[i]);
            }else{
                firstInclude.add(inputs[i]);
                lastInclude.add(inputs[i]);
            }
        }

        int[] dp1 = new int[firstInclude.size()];
        int[] dp2 = new int[lastInclude.size()];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int ans = Math.max(solve(firstInclude, firstInclude.size() - 1, dp1), solve(lastInclude, lastInclude.size() - 1, dp2));
        System.out.println(ans);
    }
    public static int solve(List<Integer> nums,int i, int[] dp) {
        if(i < 0) return 0;
        if(i == 0) return nums.get(0);

        if(dp[i] != -1) return dp[i];

        int incl = solve(nums, i-2, dp) + nums.get(i);
        int excl = solve(nums, i-1, dp) + 0;

        dp[i] = Math.max(incl, excl);

        return dp[i];
    }
}
