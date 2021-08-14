
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class CellAutomata extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final int generations = 10;
        final int rule = 2;
        List nextList = List.of(0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0);

        final Group root = new Group();
        Scene scene = new Scene(root, Color.WHITE);

        Renderer.render(generations, rule, nextList, root);
        stage.setScene(scene);
        stage.show();
    }

}
