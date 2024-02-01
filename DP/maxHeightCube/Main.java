import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12},{45,12,18}};
        int[][] cuboids = {{38,25,45},{76,35,3}};
        System.out.println(maxHeight(cuboids));
    }
    public static int maxHeight(int[][] cuboids) {

        //sort each elem to get max height at 2nd(last) position
        for(int[] row : cuboids){
            Arrays.sort(row);
        }
        // sort entire 2d array based on width (0th position)
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr2[0] == arr1[0])
                    return arr2[1] - arr1[1];
                else
                    return arr2[0] - arr1[0];
            }
        });
        // for(int[] row : cuboids){
        //     System.out.println(row[0]+" "+row[1]+" "+row[2]);
        // }
        int[] ansList = new int[cuboids.length];
        int maxHeight = cuboids[0][2];
        ansList[0] = cuboids[0][2];
        for(int i = 1; i< cuboids.length; i++){
            int subAns = 0;
            for(int j = i-1; j>=0; j--){
                if(cuboids[i][1] <= cuboids[j][1] && cuboids[i][2] <= cuboids[j][2]){
                    subAns = Math.max(ansList[j], subAns);
                }
            }
            ansList[i] = subAns + cuboids[i][2];
            maxHeight = Math.max(maxHeight, ansList[i]);
        }
        return maxHeight;
        
    }
}
