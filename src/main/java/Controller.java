
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
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

    final private List<Integer> initList = List.of(0,0,0,0,0,1,0,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,0,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0);


    private List<Integer> nextList;

    int ruleValue;

    final int screenWidth = 1080;
    final int screenHeight = 920;

    @FXML
    public void initialize() {
        Renderer renderer = new Renderer(5, screenWidth/initList.size());

        initializeCellGridPane();

        nextList = initList;
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
            nextList = Generator.generate(nextList, ruleValue);
            renderer.render(nextList, myGridPane);
        });
    }
}

