import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Renderer {
    final public static void render(List nextList, GridPane gridPane, double cellDimension){
        int y = gridPane.getRowCount();
        for(int x = 0; x < nextList.size(); x++){
            gridPane.add(createAppropriateRectangle(nextList.get(x).equals(0), cellDimension), x, y, 1, 1);
        }
    }

    final public static void render(int generations, int rule, List nextList, GridPane gridPane, double cellDimension){
        for (int y = 0; y < generations; y++) {

            for(int x = 0; x < nextList.size(); x++){
                gridPane.add(createAppropriateRectangle(nextList.get(x).equals(0), cellDimension), x, y, 1, 1);
            }
            nextList = Generator.generate(nextList,rule);
        }
    }

    final private static Rectangle createAppropriateRectangle(boolean state, double cellDimension){
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(cellDimension);
        rectangle.setWidth(cellDimension);
        rectangle.setStroke(Color.GRAY);
        if(state){
            rectangle.setFill(Color.WHITE);
        }

        return rectangle;
    }
}
