
public class App {
    public static void main(String[] args) {
        int[] arr = {2,8,1,6,3,0};
        arr = selectionSort(arr,0, arr.length);
        for(int el : arr){
            System.out.print(el+" ");
        }
    }
    public static int[] selectionSort(int[] arr,int start, int n){
        if(n <= start ) return arr;
        
        int min_index = start;
        for(int i = start+1; i<n ; i++){
            if(arr[i] < arr[min_index]){
                min_index = i;
            }
        }  
        arr = swap(arr, start, min_index);
        //recursion call
        return selectionSort(arr, start+1,n);

    }
    public static int[] swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
