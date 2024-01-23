
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,1,1},
            {0,1,1,1},
            {1,1,1,1}
        };
        int[] ans = new int[1];
        ans[0] = 0;
        minArea(matrix, 0, 0, ans);
        System.out.println(ans[0]);
    }
    public static int minArea(int[][] matrix, int i, int j,int[] ans){
        if(i >= matrix.length || j >= matrix[0].length) return 0;
        
        
        if(matrix[i][j] == 1){
            int right = minArea(matrix, i, j+1, ans);
            int diagonal = minArea(matrix, i+1, j+1, ans);
            int down = minArea(matrix, i+1, j, ans);
            int subAns = 1 + Math.min(Math.min(diagonal, down),right);
            ans[0] = Math.max(ans[0], subAns); 
            return subAns;
        }else{
            return 0;
        }
    }
}
