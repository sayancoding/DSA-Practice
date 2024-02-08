import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text = "bbbab";
        int[][] dp = new int[text.length()+1][text.length()+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println(solve(0,text.length()-1,text,dp));
    }

    public static int solve(int i , int j, String str,int[][] dp){
        if(i == str.length() || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int count = 0;

        if(str.charAt(i) == str.charAt(j)){
            count = 1 + solve(i+1, j-1, str,dp);
        }
        else{
            count = Math.max(count,solve(i+1, j, str,dp)) ;
            count = Math.max(count, solve(i, j-1, str,dp));
        }
        dp[i][j] = count;
        return dp[i][j];
    }
}
