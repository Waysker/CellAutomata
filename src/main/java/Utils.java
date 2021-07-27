import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static int[] intToBinaryArray(int input){
        int[] result = new int[8];
        for(int i = 0; i < 8; i++){
            result[result.length - 1 - i] = ((input & (1 << i)) != 0) ? 1 : 0;
        }
        return result;
    }

    public static ArrayList<Integer> intToRuleArray(int input){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            result.add(((input & (1 << i)) != 0) ? 1 : 0);
        }
        Collections.reverse(result);
        return result;
    }
}
