import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {

    private final NeighbourhoodFactory neighbourhoodFactory;

    @Inject
    public Generator(final NeighbourhoodFactory neighbourhoodFactory) {
        this.neighbourhoodFactory = neighbourhoodFactory;
    }

    // for tests purposes only
    Generator() {
        this.neighbourhoodFactory = new NeighbourhoodFactory();
    }

    private int calculateNextCell(final Neighbourhood neighbourhood, final int rule) {
        final int state = 4 * neighbourhood.left + 2 * neighbourhood.me + neighbourhood.right;
        final List<Integer> ruleArray = Utils.intToRuleArray(rule);
        return ruleArray.get(ruleArray.size() - state - 1);
    }

    public List<Integer> generate(List<Integer> array, int rule) {

        return IntStream
                .range(0, array.size())
                .map(operand -> calculateNextCell(neighbourhoodFactory.neighbourhood(array, operand), rule))
                .boxed()
                .collect(Collectors.toList());
    }
}
