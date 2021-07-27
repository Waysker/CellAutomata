
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class HelloFX extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final int generations = 10;
        ArrayList<Integer> nextList = new ArrayList<>(List.of(0,0,0,0,0,0,0,1,0,0,0,0,0,0,0));

        Group root = new Group();
        Scene scene = new Scene(root, Color.WHITE);

        for (int n = 0; n < generations; n++) {

            for(int i = 0; i < nextList.size(); i++){
                Rectangle rectangle = new Rectangle();
                rectangle.setHeight(50);
                rectangle.setWidth(50);
                rectangle.setX(50 * i);
                rectangle.setY(50 * n);
                rectangle.setStroke(Color.GRAY);
                if(nextList.get(i) == 0){
                    rectangle.setFill(Color.WHITE);
                }
                root.getChildren().add(rectangle);
            }
            nextList = Generator.generate(nextList,244);
        }
        stage.setScene(scene);
        stage.show();
    }
}
