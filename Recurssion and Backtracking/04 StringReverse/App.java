class App{
    public static void main(String[] args) {
        String inputStr = "abcde";
        System.out.println(reverse(inputStr));
    }
    public static String reverse(String inputStr){
        if(inputStr.length() == 0 || inputStr.length() == 1) return inputStr;
        return inputStr.substring(inputStr.length()-1, inputStr.length()) + reverse(inputStr.substring(0, inputStr.length()-1));
    }
}