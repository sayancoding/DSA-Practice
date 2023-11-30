
public class App {
    public static void main(String[] args) {
        String inputStr = "aabcbaa";
        System.out.println(isPalindrome(inputStr, 0, inputStr.length()-1));
    }
    public static boolean isPalindrome(String str,int i, int j){
        if(i>j) return true;
        else if(str.charAt(i) != str.charAt(j)) return false;
        else return isPalindrome(str, i+1, j-1);
    }
}
