class App{
    public static void main(String[] args) {
        int[] arr = {4,5,2,1};
        System.out.println(sum(arr, 0, arr.length));
    }
    public static int sum(int[] arr,int startIndex,int size){
        if(size == 0) return 0;
        if(size == 1) return arr[startIndex];
        
        return arr[startIndex] + sum(arr, startIndex+1, size-1);
    }
}