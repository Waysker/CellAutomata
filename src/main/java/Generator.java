
import java.sql.Array;

public class Generator {

    //create object for neighborhood
    private static int calculateNextCell(int left,int me,int right){
        int state = 4*left + 2*me + right;
        int[] rule1 = {0,0,0,0,0,0,0,1};
        return rule1[rule1.length - state - 1];
    }

    private static int calculateNextCell(int left,int me ,int right, int rule){
        int state = 4*left + 2*me + right;
        int[] ruleArray = Utils.intToBinaryArray8(rule);
        return ruleArray[ruleArray.length - state - 1];
    }
    public static int[] generate(int[] array, int rule){
        int[] nextArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int left;
            int right;
            int me = array[i];
            //out of bound neighbors are zero
            if(i != 0){
                left = array[i-1];
            } else {
                left = 0;
            }
            if( i != array.length - 1){
                right = array[i+1];
            } else {
                right = 0;
            }
            nextArray[i] = calculateNextCell(left, me, right, rule);
        }
        return nextArray;
    };

    public static int[] generate(int[] array){
        int[] nextArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int left;
            int right;
            int me = array[i];
            //out of bound neighbors are zero
            if(i != 0){
                left = array[i-1];
            } else {
                left = 0;
            }
            if( i != array.length - 1){
                right = array[i+1];
            } else {
                right = 0;
            }
            nextArray[i] = calculateNextCell(left, me, right);
        }
      return nextArray;
    };

}
