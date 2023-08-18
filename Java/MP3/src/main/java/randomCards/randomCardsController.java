package randomCards;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class randomCardsController {
    private int numb1;
    private int numb2;
    private int numb3;
    private int numb4;
    private Random rand = new Random();

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;

    private String filepath = "file:/C:/Users/jsikw/IdeaProjects/MP3/src/main/resources/card/";

    public void initialize(){
        numb1 = rand.nextInt(54) +1;
        numb2 = rand.nextInt(54) +1;
        numb3 = rand.nextInt(54) +1;
        numb4 = rand.nextInt(54) +1;
    }
    @FXML
    public void onImgClicked(MouseEvent e){
        if(e.getSource().equals(img1)) {
            img1.setImage(new Image(filepath + numb1 + ".png"));
        } else if(e.getSource().equals(img2)) {
            img2.setImage(new Image(filepath + numb2 + ".png"));
        }else if(e.getSource().equals(img3)) {
            img3.setImage(new Image(filepath + numb3 + ".png"));
        }else if(e.getSource().equals(img4)) {
            img4.setImage(new Image(filepath + numb4 + ".png"));
        }
    }
    @FXML
    public void onBtnClicked() {
        numb1 = rand.nextInt(54) +1;
        numb2 = rand.nextInt(54) +1;
        numb3 = rand.nextInt(54) +1;
        numb4 = rand.nextInt(54) +1;
        img1.setImage(new Image(filepath + "back.png"));
        img2.setImage(new Image(filepath + "back.png"));
        img3.setImage(new Image(filepath + "back.png"));
        img4.setImage(new Image(filepath + "back.png"));


    }
}
