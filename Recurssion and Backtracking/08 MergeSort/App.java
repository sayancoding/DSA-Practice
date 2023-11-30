import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arr = {2,8,1,6,3,0};
        arr = mergeSort(arr);
        for(int el : arr){
            System.out.print(el+" ");
        }
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;

        int mid = arr.length / 2;

        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);

        int[] ls = mergeSort(leftArr);
        int[] rs = mergeSort(rightArr);

        return merge(ls,rs);
    }
    public static int[] merge(int[] leftArr,int[] rightArr){
        int[] arr = new int[leftArr.length+rightArr.length];
        int left_idx = 0;
        int right_idx = 0;
        int k = 0;
        
        while (left_idx < leftArr.length && right_idx < rightArr.length) {
            if(leftArr[left_idx] <= rightArr[right_idx]){
                arr[k++] = leftArr[left_idx++];
            }else{
                arr[k++] = rightArr[right_idx++];
            }
        }
        while (left_idx < leftArr.length){
            arr[k++] = leftArr[left_idx++];
        }
        while (right_idx < rightArr.length){
            arr[k++] = rightArr[right_idx++];
        }
        return arr;
    }  

}

