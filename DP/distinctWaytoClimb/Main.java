
public class Main {
    public static void main(String[] args) {
        int destination = 4;
        int[] memo = new int[destination + 1]; 
        System.out.println(solve(0, destination,memo));
    }
    public static int solve(int pos, int destination, int[] memo){
        // 1: base case
        if(pos == destination) return 1;
        if(pos > destination) return 0;

        // 2: check on table
        if(memo[pos] != 0) return memo[pos];
        
        // 3. calculate nd store on dp table
        memo[pos] = solve(pos+1, destination,memo) + solve(pos+2, destination,memo);
        
        return memo[pos];
    }
}
