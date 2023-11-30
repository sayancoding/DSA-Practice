
public class App {
    public static void main(String[] args) {
        int[] arr = {5,7,9,1,0,3,2};
        quickSort(arr, 0, arr.length-1);
        show(arr);
    }

    static void quickSort(int[] arr, int start, int end){
        if(start >= end) return;

        int pivot = partition(arr,start,end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }
    static int partition(int[] arr, int start, int end){
        
        int count  = 0;
        for(int i = start+1; i<=end; i++){
            if(arr[start] > arr[i]) count++;
        }
        int pivot_idx = start+count;
        swap(arr, start, pivot_idx);
        ;
        int i = start;
        int j = end;

        while (i < pivot_idx && j > pivot_idx) {
            while (arr[i] < arr[pivot_idx]) {
                i++;
            }
            while (arr[j] > arr[pivot_idx]) {
                j--;
            }

            if(i < pivot_idx && j > pivot_idx){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivot_idx;
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void show(int[] arr){
        for(int el : arr){
            System.out.print(el+" ");
        }
        System.err.println();
    }
}
