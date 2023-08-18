module edu.wccnet.jwon1.mp3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.wccnet.jwon1.mp3 to javafx.fxml;
    exports edu.wccnet.jwon1.mp3.converter;
    opens edu.wccnet.jwon1.mp3.converter to javafx.fxml;
    exports randomCards;
    opens randomCards to javafx.fxml;
    exports hockeyStats;
    opens hockeyStats to javafx.fxml;
}