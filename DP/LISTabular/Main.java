public class Main {
    public static void main(String[] args) {
        int[] input = {2,3,5,4,5,6,5,7,8};
        //  int[] input = {5,8,3,7,9,1};
        System.out.println(solveTabular(input));
    }
    public static int solveTabular(int[] input){
        int[] ansList = new int[input.length];
        int maxAns = 1;
        ansList[0] = 1;
        for(int i = 1; i< input.length; i++){
            int subAns = 0;
            for(int j = i-1; j>=0; j--){
                if(input[i] > input[j]){
                    subAns = Math.max(ansList[j], subAns);
                }
            }
            ansList[i] = subAns + 1;
            maxAns = Math.max(maxAns, ansList[i]);
        }
        return maxAns;
    }
}
