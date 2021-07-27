
import java.util.ArrayList;
import java.util.List;

public class Generator {

    //create object for neighborhood
    private static int calculateNextCell(Neighbourhood nh){
        int state = 4*nh.left + 2*nh.me + nh.right;
        int[] rule1 = {0,0,0,0,0,0,0,1};
        return rule1[rule1.length - state - 1];
    }

    private static int calculateNextCell(Neighbourhood nh, int rule){
        int state = 4*nh.left + 2*nh.me + nh.right;
        List<Integer> ruleArray = Utils.intToRuleArray(rule);
        return ruleArray.get(ruleArray.size() - state - 1);
    }
    public static ArrayList<Integer> generate(ArrayList<Integer> array, int rule){
        ArrayList<Integer> nextArray = new ArrayList<>();

        for(int i = 0; i < array.size(); i++){

            nextArray.add(calculateNextCell(new Neighbourhood(array, i), rule));
        }
        return nextArray;
    };



}
