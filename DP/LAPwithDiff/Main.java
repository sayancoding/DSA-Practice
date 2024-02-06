import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int diff = -2;
        System.out.println(longestSubsequence(arr, diff));
    }
    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int el : arr){
            int diff = el - difference;
            int tempAns = 0;
            if(map.containsKey(diff)){
                tempAns = map.get(diff);
            }
            map.put(el, tempAns +1);
            ans = Math.max(ans,map.get(el));
        }
        return ans;
    }

}
