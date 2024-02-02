import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] slices = {1,2,3,4,5,6};
        System.out.println(maxSizeSlices(slices));
    }
    public static int maxSizeSlices(int[] slices) {
        int[][] dp = new int[slices.length][slices.length];
        for(int[] row : dp) Arrays.fill(row,-1);

        int firstIncl = solve(slices, 0, slices.length - 2, slices.length/3 , dp);

        for(int[] row : dp) Arrays.fill(row,-1);
        int firstExcl = solve(slices, 1, slices.length - 1, slices.length/3, dp);
        
        return Math.max(firstExcl,firstIncl);
    }
    public static int solve(int[] slices,int startIndex,int endIndex,int capacity,int[][] dp){
        if(capacity == 0 || startIndex > endIndex)
        return 0;

        if(dp[startIndex][capacity] != -1) return dp[startIndex][capacity];

        int take = slices[startIndex] + solve(slices, startIndex+2, endIndex, capacity - 1, dp);

        int notTake = 0 + solve(slices, startIndex+1, endIndex , capacity, dp);

        dp[startIndex][capacity] = Math.max(take,notTake);
        return dp[startIndex][capacity];
    }

}
