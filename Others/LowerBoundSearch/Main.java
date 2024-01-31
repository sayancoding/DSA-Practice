import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        System.out.println(lowerBound(arr, 5, 0 , arr.length ));
    }
    public static int lowerBound(int[] arr,int key, int start, int end){
        int index = Arrays.binarySearch(arr,start,end, key);
        if(index < 0) 
            index = index -(index + 1);
        
        return index;
    }
}
