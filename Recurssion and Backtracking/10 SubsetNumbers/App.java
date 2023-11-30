import java.util.*;

public class App {
    public static void main(String[] args) {
        int[] input = {1,2,3}; 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        subset(input, 0, new ArrayList<Integer>(), ans);
        System.out.println(ans); 
    }
    public static void subset(int[] input,int index,ArrayList<Integer>subset, 
                                            ArrayList<ArrayList<Integer>> ans){
        if(index >= input.length){
            ans.add(subset);
            return;
        }
        ArrayList<Integer> copy_SubSet = (ArrayList<Integer>) subset.clone();
        //exclude call
        subset(input, index+1, copy_SubSet, ans);

        //include call
        subset.add(input[index]);
        subset(input, index+1, subset, ans);
    }
}
