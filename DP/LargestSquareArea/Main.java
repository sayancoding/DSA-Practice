import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,1,1},
            {0,1,1,1},
            {1,1,1,1}
        };
        int[] ans = new int[1];
        ans[0] = 0;
        
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for (int[] row: dp)
        Arrays.fill(row, -1);

        minArea(matrix, 0, 0, ans, dp);
        System.out.println(ans[0]);
    }
    public static int minArea(int[][] matrix, int i, int j,int[] ans,int[][] dp){
        if(i >= matrix.length || j >= matrix[0].length) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(matrix[i][j] == 1){
            int right = minArea(matrix, i, j+1, ans, dp);
            int diagonal = minArea(matrix, i+1, j+1, ans, dp);
            int down = minArea(matrix, i+1, j, ans, dp);
            
            dp[i][j] = 1 + Math.min(Math.min(diagonal, down),right);
            
            ans[0] = Math.max(ans[0], dp[i][j]); 
            return dp[i][j];
        }else{
            return 0;
        }
    }
}
