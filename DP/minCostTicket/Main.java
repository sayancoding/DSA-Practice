public class Main {
    public static void main(String[] args) {
        int[] days = {1,3, 4, 5, 7, 8, 10};
        int[] cost = {2, 7, 20};
        System.out.println(minimumCoins(days.length, days, cost));
    }
    public static int minimumCoins(int n, int[] days, int[] cost) {
		return solve(n, days, cost,0);	
	}
    public static int solve(int n, int[] days, int[] cost,int index){

        if(index >= n) return 0;

        //option1
        int option1 = cost[0] + solve(n, days, cost, index+1);
        //option2
        int i = index;
        while(i < n && days[i] < days[index]+7){
            i++;
        }
        int option2 = cost[1] + solve(n, days, cost, i);

        //option3
        int j = index;
        while(j < n && days[j] < days[index]+30){
            j++;
        }
        int option3 = cost[2] + solve(n, days, cost, j);

        int ans = Math.min(Math.min(option1, option2),option3);
        return ans;
    }
}
