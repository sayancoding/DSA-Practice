import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // int[] input = {5,8,3,7,9,1};
        int[] input = {2,3,5,4,5,6,5,7,8};
        System.out.println(lengthOfLIS(input));
    }
    public static int lengthOfLIS(int[] a) {
        int[][] dp = new int[a.length][a.length + 1];
        for(int[] row : dp)
        Arrays.fill(row, -1);
        // return solve(a, 0, -1,dp);
        return solveWithBinarySearch(a);
    }
    public static int solve(int[] nums,int curr, int prev, int[][] dp){
        if( curr == nums.length) return 0;

        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];

        int inclu = 0;
        if( prev == -1 || nums[curr] > nums[prev] ){
            inclu = 1 + solve(nums, curr+1, curr,dp);
        }

        int exclu = solve(nums, curr+1, prev,dp);

        dp[curr][prev+1] = Math.max(inclu, exclu);
        return dp[curr][prev+1];
    }
    
    public static int solveWithBinarySearch(int[] nums){
        int[] list = new int[nums.length];

        list[0] = nums[0];
        int lastIndex = 0;

        for(int i = 1; i<nums.length; i++){
            if(nums[i] > list[lastIndex]){
                list[++lastIndex] = nums[i];
            }
            else{
                int idx = lowerBound(list,0,lastIndex+1, nums[i]);
                if(idx >= 0)
                list[idx] = nums[i];
            }
        }
        return lastIndex+1 ;
    }
    public static int lowerBound(int[] arr,int start, int end,int key){
        int index = Arrays.binarySearch(arr,start,end, key);
        if(index < 0) 
            index = -(index + 1);
        return index;
    }
}
