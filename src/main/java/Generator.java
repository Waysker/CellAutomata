
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {

    private static int calculateNextCell(final Neighbourhood neighbourhood, int rule){
        int state = 4*neighbourhood.left + 2*neighbourhood.me + neighbourhood.right;
        List<Integer> ruleArray = Utils.intToRuleArray(rule);
        return ruleArray.get(ruleArray.size() - state - 1);
    }


    public static List<Integer> generate(List<Integer> array, int rule){

        NeighbourhoodFactory neighbourhoodFactory = new NeighbourhoodFactory();
        List<Integer> nextArray = IntStream
                        .range(0, array.size())
                        .map(operand -> calculateNextCell(neighbourhoodFactory.neighbourhood(array, operand), rule))
                        .boxed()
                        .collect(Collectors.toList());
        return nextArray;
    };


}
