import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> mazeInput = new ArrayList<>();
        //taking user inputs
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] visitedMaze = new int[row][col];
        for(int i = 0; i<row; i++){
            ArrayList<Integer> rowList = new ArrayList<>();
            for(int j = 0; j<col; j++){
                int temp = sc.nextInt();
                rowList.add(temp);
                visitedMaze[i][j] = 0;
            }mazeInput.add(rowList);
        }
        ArrayList<String> ans = new ArrayList<>();
        String step = "";
        mazeSolver(mazeInput, visitedMaze, 0, 0, step, ans);
        System.out.println(ans);
    }
    public static void mazeSolver(ArrayList<ArrayList<Integer>> mazeInput, int[][] visitedMaze,int x,int y , String step, ArrayList<String> ans){
        if(x == (mazeInput.size()-1) && y == (mazeInput.get(0).size()-1)){
            if(step.length() != 0){
                ans.add(step);
            }
            return;
        }
        
        visitedMaze[x][y] = 1;
        int newX;
        int newY;
        //left
        newX = x; newY = y-1;
        if(isSafe(mazeInput, visitedMaze, newX, newY)){
            step = step + "L";
            mazeSolver(mazeInput, visitedMaze, newX, newY, step, ans);
            //backtracking - reset to previous step
            step = step.substring(0, step.length()-1);
        }

        //right
        newX = x; newY = y+1;
        if(isSafe(mazeInput, visitedMaze, newX, newY)){
            step = step + "R";
            mazeSolver(mazeInput, visitedMaze, newX, newY, step, ans);
            //backtracking - reset to previous step
            step = step.substring(0, step.length()-1);
        }

        //top
        newX = x-1; newY = y;
        if(isSafe(mazeInput, visitedMaze, newX, newY)){
            step = step + "T";
            mazeSolver(mazeInput, visitedMaze, newX, newY, step, ans);
            //backtracking - reset to previous step
            step = step.substring(0, step.length()-1);
        }
        //down
        newX = x+1; newY = y;
        if(isSafe(mazeInput, visitedMaze, newX, newY)){
            step = step + "D";
            mazeSolver(mazeInput, visitedMaze, newX, newY, step, ans);
            //backtracking - reset to previous step
            step = step.substring(0, step.length()-1);
        }
        //backtracking
        visitedMaze[x][y] = 0;
    }
    public static boolean isSafe(ArrayList<ArrayList<Integer>> mazeInput,int[][] visitedMaze,int x,int y){
        if(x < mazeInput.size() && y < mazeInput.get(0).size() && x >= 0 && y >= 0 
                && mazeInput.get(x).get(y) == 1 && visitedMaze[x][y] == 0) 
                return true;
        return false;
    }

    public static void view(ArrayList<ArrayList<Integer>> mazeInput){
        for(int i = 0; i<mazeInput.size(); i++){
            for(int j = 0; j<mazeInput.get(i).size(); j++){
                System.out.print(mazeInput.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void view(int[][] mazeInput){
        for(int i = 0; i<mazeInput.length; i++){
            for(int j = 0; j<mazeInput[0].length; j++){
                System.out.print(mazeInput[i][j]+" ");
            }
            System.out.println();
        }
    }
}
