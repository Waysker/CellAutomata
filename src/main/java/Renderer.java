import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Renderer {

    final public static void render(int generations, int rule, List nextList, Group root){
        for (int y = 0; y < generations; y++) {

            for(int x = 0; x < nextList.size(); x++){

                root.getChildren().add(createAppropriateRectangle(x, y, nextList.get(x).equals(0)));
            }
            nextList = Generator.generate(nextList,rule);
        }
    }

    final private static Rectangle createAppropriateRectangle(int x, int y, boolean state){
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(50);
        rectangle.setWidth(50);
        rectangle.setX(50 * x);
        rectangle.setY(50 * y);
        rectangle.setStroke(Color.GRAY);
        if(state){
            rectangle.setFill(Color.WHITE);
        }

        return rectangle;
    }
}
