import java.util.ArrayList;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        String input = "abc";
        HashSet<String> ans = new HashSet<>();
        permutation(input, 0, ans);
        System.out.println(ans);
    }

    public static void permutation(String input, int indx, HashSet<String> ans) {
        if (indx >= input.length()) {
            ans.add(input);
            return;
        }
        for (int i = indx; i < input.length(); i++) {
            input = swap(input, indx, i);
            permutation(input, indx + 1, ans);
            //backtracking - again swap to be previous order
            input = swap(input, i, indx);
        }
    }

    static String swap(String input, int i, int j) {
        char[] c = input.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return new String(c);
    }
}
