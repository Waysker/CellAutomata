
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;

import javax.inject.Inject;
import java.util.List;


public class Controller {

    @FXML
    private Spinner<Integer> mySpinner;

    @FXML
    private Button nextButton;

    @FXML
    private Label myLabel;

    @FXML
    private GridPane myGridPane;


    private List<Integer> nextList;

    int ruleValue;

    private final Generator generator;
    private final Renderer renderer;
    private final Configuration configuration;

    @Inject
    public Controller(final Generator generator,
                      final Renderer renderer,
                      final Configuration configuration) {
        this.generator = generator;
        this.renderer = renderer;
        this.configuration = configuration;
    }

    @FXML
    public void initialize() {

        initializeCellGridPane();

        nextList = configuration.getInitList();
        renderer.render(nextList, myGridPane);

        initializeSpinner();

        initializeNextButton(renderer);

    };

    private void initializeCellGridPane(){

        myGridPane.getChildren().removeAll();
        myGridPane.setGridLinesVisible(true);

    }

    private void initializeSpinner(){

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,255,1);

        valueFactory.setValue(1);
        mySpinner.setValueFactory(valueFactory);
        ruleValue = mySpinner.getValue();

        mySpinner.valueProperty().addListener((observableValue, integer, t1) -> ruleValue = mySpinner.getValue());
    }

    private void initializeNextButton(Renderer renderer){
        nextButton.setOnMouseClicked(mouseEvent -> {
            nextList = generator.generate(nextList, ruleValue);
            renderer.render(nextList, myGridPane);
        });
    }
}

