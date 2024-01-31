import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        // int[][] envelopes = {{1,1},{1,1},{1,1}};
        // int[][] envelopes = {{30,50},{12,2},{3,4},{12,15}};
        int[][] envelopes = {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });

        int[] list = new int[envelopes.length];

        list[0] = envelopes[0][1];
        int lastIndex = 0;

        for(int i = 1; i<envelopes.length; i++){
            if(envelopes[i][1] > list[lastIndex]){
                list[++lastIndex] = envelopes[i][1];
            }
            else{
                int idx = lowerBound(list,0,lastIndex+1, envelopes[i][1]);
                if(idx >= 0)
                list[idx] = envelopes[i][1];
            }
        }
        return lastIndex + 1 ;

    }
    public static int lowerBound(int[] arr,int start, int end,int key){
        int index = Arrays.binarySearch(arr,start,end, key);
        if(index < 0) 
            index = -(index + 1);
        return index;
    }
}
