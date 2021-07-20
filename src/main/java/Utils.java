public class Utils {

    public static int[] intToBinaryArray8(int input){
        int[] result = new int[8];
        for(int i = 0; i < 8; i++){
            result[result.length - 1 - i] = ((input & (1 << i)) != 0) ? 1 : 0;
        }
        return result;
    }
}
