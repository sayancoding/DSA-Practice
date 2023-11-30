import java.util.ArrayList;
import java.util.List;

class App{
    public static void main(String[] args) {
        String input = "29";
        ArrayList<String> ans = new ArrayList<>();
        String[] mappedDict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(input, 0,"",ans, mappedDict);
        System.out.println(ans);
    }
    public static void solve(String input, int indx,String subString,ArrayList<String> ans, String[] dict){
        if(indx >= input.length()){
            ans.add(subString);
            return;
        }
        int digit = (input.charAt(indx) - '0');
        String value = dict[digit];

        for(int i = 0; i < value.length(); i++){
            subString = subString + value.charAt(i);
            solve(input, indx+1, subString, ans, dict);

            //backtracking - by removing recent most added char
            subString = subString.substring(0, subString.length()-1);
            
        }

    }
}