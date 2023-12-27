import java.util.HashMap;

class Main{
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map_1 = new HashMap<>();
        HashMap<Character,Character> map_2 = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            if(map_1.containsKey(s.charAt(i))){
                if(map_1.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else{
                map_1.put(s.charAt(i), t.charAt(i));
            }

            if(map_2.containsKey(t.charAt(i))){
                if(map_2.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }else{
                map_2.put(t.charAt(i), s.charAt(i));
            }
            
        }
        return true;
    }

}