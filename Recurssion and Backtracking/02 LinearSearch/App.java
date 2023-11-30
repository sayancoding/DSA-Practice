package Recurssion.LinearSearch;

public class App {
    public static void main(String[] args) {
        int[] arr = {4,8,1,0,3};
        System.out.println(isFound(arr, 0, arr.length, 7));
    }
    public static boolean isFound(int[] arr, int startIndex, int size, int findingEl){
        if(size == 0) return false;
        if(size == 1 && arr[startIndex] != findingEl) return false;
        if(size == 1 && arr[startIndex] == findingEl) return true;
        if(arr[startIndex] == findingEl) return true;
        return isFound(arr, startIndex+1, size-1, findingEl);
    }
}
