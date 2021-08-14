import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;


public class Renderer {

    final int colMax;
    final double cellDimension;

    public void render(List<Integer> nextList, GridPane gridPane) {

        int y = Math.min(gridPane.getRowCount(), colMax - 1);

        if (gridPane.getRowCount() >= colMax) {
            moveRowsUpByOne(gridPane);
        }
        createRowOfRectangles(nextList, gridPane, y);

    }

    private void moveRowsUpByOne(GridPane gridPane) {
        ArrayList<ArrayList<Node>> gridPaneNodes = new ArrayList<>();
        for(int i = 0; i < gridPane.getRowCount(); i++) {
            gridPaneNodes.add(new ArrayList());
        }
        gridPane.getChildren().stream()
                .filter(this::isRowAndColumnIndexNotNull)
                .forEach(node -> addNodeToList(gridPaneNodes, node));

        gridPaneNodes.stream()
                .filter(this::isRowIndexNotZero)
                .forEach(this::decrementRowIndex);

    }

    private void addNodeToList(ArrayList<ArrayList<Node>> gridPaneNodes, Node node) {
        gridPaneNodes.get(GridPane.getRowIndex(node)).add(GridPane.getColumnIndex(node), node);
    }

    private boolean isRowAndColumnIndexNotNull(Node node) {
        return GridPane.getColumnIndex(node) != null && GridPane.getRowIndex(node) != null;
    }

    private boolean isRowIndexNotZero(ArrayList<Node> nodesRow) {
        return GridPane.getRowIndex(nodesRow.get(0)) != 0;
    }

    private void decrementRowIndex(List<Node> nodesRow) {
        nodesRow
                .forEach(node -> GridPane.setRowIndex(node, GridPane.getRowIndex(node) - 1));
    }

    private void createRowOfRectangles(List<Integer> nextList, GridPane gridPane, int y) {
        for (int x = 0; x < nextList.size(); x++) {
            gridPane.add(createAppropriateRectangle(nextList.get(x).equals(0), cellDimension), x, y, 1, 1);
        }
    }

    private static Rectangle createAppropriateRectangle(boolean state, double cellDimension){
        Rectangle rectangle = new Rectangle(cellDimension, cellDimension);
        rectangle.setStroke(Color.GRAY);
        if(state){
            rectangle.setFill(Color.WHITE);
        }

        return rectangle;
    }

    public Renderer(int colMax, double cellDimension) {
        this.colMax = colMax;
        this.cellDimension = cellDimension;
    }
}
