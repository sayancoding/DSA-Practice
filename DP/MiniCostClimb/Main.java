class Main{
    public static void main(String[] args) {
        int[] input = {1,100,1,1,1,100,1,1,100,1};
        int n = input.length;
        int[] memo = new int[n+1];
        for(int i = 0; i<n; i++){
            memo[i] = -1;
        }

        int ans = Math.min(solve(input, n-1, memo), solve(input, n-2, memo));
        System.out.println(ans);
    }
    public static int solve(int[] arr, int n , int[] memo){
        // 1: Basecase
        if(n == 0 || n == 1) return arr[n];

        // 2: check on table
        if(memo[n] != -1) return memo[n];

        memo[n] = arr[n] + Math.min(solve(arr, n-1 , memo), solve(arr, n-2, memo));
        
        return memo[n];
    }

}
