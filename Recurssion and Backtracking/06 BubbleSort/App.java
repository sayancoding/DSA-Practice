
public class App {
    public static void main(String[] args) {
        int[] arr = {2,8,1,6,3,0};
        arr = bubbleSort(arr, arr.length);
        for(int el : arr){
            System.out.print(el+" ");
        }
    }

    public static int[] bubbleSort(int[] arr, int n){
        if(n == 0 || n == 1) return arr;
        // shifting largest element to last
        for(int i = 0; i<n-1 ; i++){
            if(arr[i]>arr[i+1]){
                arr = swap(arr, i, i+1);
            }
        }
        //recursion call
        return bubbleSort(arr, n-1);

    }

    public static int[] swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
