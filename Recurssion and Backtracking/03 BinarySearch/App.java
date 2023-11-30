package Recurssion.BinarySearch;

public class App {
    public static void main(String[] args) {
        int[] arr = {2,4,6,10,14,16};
        int mid = arr.length/2;
        System.out.println(isFound(arr, 0, mid, arr.length, 6));
    }
    public static boolean isFound(int[] arr,int start,int mid,int size,int ele){
        if(size == 0) return false;
        else if(size == 1 && arr[start] != ele) return false;
        else if(size == 1 && arr[start] == ele) return true;
        else if(arr[mid] == ele) return true;
        else if(ele < arr[mid]){
            return isFound(arr, start,  mid/2, mid, ele);
        }
        else if (ele > arr[mid]){
            return isFound(arr, mid+1,  (mid+size)/2, size-1, ele);
        }
        else return false;
    }
}
