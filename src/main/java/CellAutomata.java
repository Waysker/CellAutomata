import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class CellAutomata extends Application {

    final int width = 1080;
    final int height = 920;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Injector injector = Guice.createInjector(new MainModule());

        final var fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        fxmlLoader.setControllerFactory(injector::getInstance);

        final var root = fxmlLoader.<Parent>load();
        Scene scene = new Scene(root, width, height, Color.WHITE);

        stage.setScene(scene);
        stage.show();
    }


}
