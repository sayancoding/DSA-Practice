import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5}};
        // int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(cherryPickup(grid));
    }
    public static int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] dp = new int[row+1][col+1][col+1];

        for(int[][] dp_row1 : dp)
            for(int[] dp_row : dp_row1)
                Arrays.fill(dp_row, -1);

        return solver(grid,row,col, 0, 0, col-1,dp);
    }
    public static int solver(int[][] grid,int row, int col,int i, int j1,int j2,int[][][] dp){
        
        // base case -- out side
        if(j1 >= col || j1 < 0 ||  j2 >= col || j2 < 0) return 0;
        // at last row
        if(i == row-1){
            if(j1==j2) return grid[i][j1];
            else return (grid[i][j1] + grid[i][j2]);
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int sum = 0;

        if(i < row){
            int max = 0;
            sum += grid[i][j1];
            if(j1!=j2) sum += grid[i][j2];

            for(int m = j1-1; m <= j1+1; m++){
                for(int n = j2-1; n <=j2+1; n++){
                    max = Math.max(max , solver(grid, row, col, i+1, m, n,dp));
                }
            }

            sum += max;
        }
        dp[i][j1][j2] = sum;
        return dp[i][j1][j2];
    

        
        
    
    }
}
