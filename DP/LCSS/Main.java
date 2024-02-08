import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text1 = "abce";
        String text2 = "be";
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println(solve(0,0,text1, text2,dp));
    }

    public static int solve(int i , int j, String str1, String str2,int[][] dp){
        if(i == str1.length() || j == str2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int count = 0;

        if(str1.charAt(i) == str2.charAt(j)){
            count = 1 + solve(i+1, j+1, str1, str2,dp);
        }
        else{
            count = Math.max(count,solve(i+1, j, str1, str2,dp)) ;
            count = Math.max(count, solve(i, j+1, str1, str2,dp));
        }
        dp[i][j] = count;
        return dp[i][j];
    }
}
