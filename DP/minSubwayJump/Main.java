import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] obstacles = {0,2,1,0,3,0};
        System.out.println(minSideJumps(obstacles));
    }
    public static int minSideJumps(int[] obstacles) {
        int[][] dp = new int[obstacles.length+1][4];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(obstacles, 2, 0,dp);
    }
    public static int solve(int[] obstacles, int currLane, int currPos ,int[][] dp ){
        if(currPos == obstacles.length-1) return 0;

        if(dp[currPos][currLane] != -1) return dp[currPos][currLane];

        if(obstacles[currPos+1] != currLane){
            return solve(obstacles, currLane, currPos+1, dp);
        }
        else{
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i<=3; i++){
                if(currLane != i && obstacles[currPos] != i)
                {
                    ans = Math.min(ans, 1 + solve(obstacles, i, currPos, dp));
                }
            }
            dp[currPos][currLane] = ans;
            return ans;
        }
    }    
}
