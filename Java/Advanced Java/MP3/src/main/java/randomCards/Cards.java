package randomCards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Cards extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(Cards.class.getResource("randomCards.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        GridPane root = FXMLLoader.load(Cards.class.getResource("randomCards.fxml"));
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Random Cards");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}
