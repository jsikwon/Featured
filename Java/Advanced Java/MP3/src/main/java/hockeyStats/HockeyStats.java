package hockeyStats;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class HockeyData{
    String teamName;
    double data;
    public HockeyData(String teamName, double data) {
        this.teamName = teamName;
        this.data = data;
    }
}
public class HockeyStats extends Application {
    ArrayList<HockeyData> stats = new ArrayList<>();
    double maxScore;

    public void fillArrayList() {
        Scanner fis = null;
        String string;
        String[] temp;
        String teamName;
        double data;
        try {
            fis = new Scanner(new FileInputStream("mp3_hockey_stats.txt"));
            while(fis.hasNextLine()) {
                string = fis.nextLine();
                temp = string.split(",");
                teamName = temp[0];
                data = Double.valueOf(temp[1]);
                stats.add(new HockeyData(teamName,data));
                System.out.println(teamName);
                System.out.println(data);
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            } finally {
                fis.close();
            }
            for (HockeyData hockeyData : stats) {
                if(hockeyData.data > maxScore) {
                    maxScore = hockeyData.data;
                }
            }
    }
        @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.setVgap(25);
        fillArrayList();
        int rowNumb = stats.size();

        for(int i = 0; i < rowNumb; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.heightProperty().bind(pane.heightProperty().divide(rowNumb).subtract(25));
            rectangle.widthProperty().bind(pane.widthProperty().subtract(100).multiply(stats.get(i).data/maxScore));
            pane.add(new Label(stats.get(i).teamName),0,i);
            pane.add(rectangle,1,i);

        }
        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Hockey Stats");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
