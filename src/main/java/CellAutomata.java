
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class CellAutomata extends Application {

    List nextList = List.of(0,0,0,0,0,1,0,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,0,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0
            ,0,0,0,0,0,0,1,0,0,0);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final int generations = 20;
        AtomicInteger rule = new AtomicInteger(129);
        //List nextList = List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0);

        //List nextList = List.of(0,1);
        final Group root = new Group();
        final GridPane gridPane = new GridPane();
        final GridPane buttonPane = new GridPane();
        final Button startButton = new Button("Start");
        final Spinner spinner = new Spinner(1,255,1);
       // slider.getOnMouseExited(mouseEvent -> mouseEvent);
        spinner.setEditable(true);
        buttonPane.add(startButton,0,0,1,1);
        buttonPane.add(spinner,1,0,1,1);
        root.getChildren().add(gridPane);
        root.getChildren().add(buttonPane);



        stage.setWidth(1080);
        stage.setHeight(920);

        final double cellDimension = stage.getWidth() / nextList.size();


        spinner.setOnMouseExited(mouseEvent -> rule.set((int) spinner.getValue()));
        startButton.setOnMouseClicked((mouseEvent -> {
            nextList = Generator.generate(nextList, rule.get());
            Renderer.render(nextList, gridPane, cellDimension);
        }));


        //Renderer.render(generations, rule, nextList, gridPane, cellDimension);
        gridPane.setLayoutY(50);
        Scene scene = new Scene(root, Color.WHITE);
        stage.setScene(scene);
        stage.show();
    }

    final private void createNextGeneration(List<Integer> nextList, GridPane gridPane, double cellDimension) {
        Renderer.render(nextList, gridPane, cellDimension);
    }

}
