import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] num1 = {1,3,5,4};
        int[] num2 = {1,2,3,7};
        System.out.println(minSwap(num1, num2));
        // int a = 5; int b = 10;
        // swap(a, b);
        // System.out.println(a + " " + b);
    }
    public static int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(nums1, nums2, 0, 0,dp);
    }
    public static int solve(int[] nums1, int[] nums2, int i, int swapNeed,int[][] dp){
        if(i == nums1.length) return 0;

        if(dp[i][swapNeed] != -1) return dp[i][swapNeed];

        int prev1;
        int prev2;
        if(i == 0){
            prev1 = -1;
            prev2 = -1;
        }else{
            prev1 = nums1[i-1];
            prev2 = nums2[i-1];
        }

        //twist
        if(swapNeed == 1)
        {
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }

        int ans1 = Integer.MAX_VALUE;
        // without swapNeed
        if(prev1 < nums1[i] && prev2 < nums2[i]){
            ans1 = solve(nums1, nums2, i+1, 0,dp);
        }
        // with swapNeed
        if(prev2 < nums1[i] && prev1 < nums2[i]){
            ans1 = Math.min(ans1, 1 + solve(nums1, nums2, i+1, 1,dp));
            dp[i][swapNeed] = ans1;
        }

        return ans1;
    }
    
}
