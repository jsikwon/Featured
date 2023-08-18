package edu.wccnet.jwon1.mp3.converter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ConverterController {
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    Label l1;
    @FXML
    Label l2;
    @FXML
    Button convert;
    @FXML
    RadioButton rBtnTemp;
    @FXML
    RadioButton rBtnDistance;
    @FXML
    RadioButton rBtnWeight;

    @FXML
    public void initialize() {
        convert.setDisable(true);
        text1.setDisable(true);
        text2.setDisable(true);
    }
    @FXML
    public void setLabel() {
        if (rBtnTemp.isSelected()) {
            // resetText();
            l1.setText("Fahrenheit:");
            l2.setText("Celcius:");
        }
        if (rBtnDistance.isSelected()) {
            // resetText();
            l1.setText("Miles:");
            l2.setText("Kilometer:");
        }
        if (rBtnWeight.isSelected()) {
            // resetText();
            l1.setText("Pound:");
            l2.setText("Kilogram:");
        }
        convert.setDisable(false);
    }
    public void convert() {
        double tempNumber;
        if (rBtnTemp.isSelected()) {
            if (text1.getText().isEmpty()) {
                tempNumber = Double.valueOf(text2.getText());
                text1.setText(String.valueOf(tempNumber * 9 / 5 + 32));
            } else {
                tempNumber = Double.valueOf(text1.getText());
                text2.setText(String.valueOf((tempNumber - 32) * 5 / 9));
            }
        } else if (rBtnDistance.isSelected()) {
            if (!text1.getText().isEmpty()) {
                tempNumber = Double.valueOf(text1.getText());
                text2.setText(String.valueOf(tempNumber * 1.609));
            }
                if (!text2.getText().isEmpty()) {
                    tempNumber = Double.valueOf(text2.getText());
                    text1.setText(String.valueOf(tempNumber / 1.609));
                }

            } else if (rBtnWeight.isSelected()) {
                if (!text1.getText().isEmpty()) {
                    tempNumber = Double.valueOf(text1.getText());
                    text2.setText(String.valueOf(tempNumber * 0.4536));
                }
                if (!text2.getText().isEmpty()) {
                    tempNumber = Double.valueOf(text2.getText());
                    text1.setText(String.valueOf(tempNumber / 0.4536));
                }
            }
        }
        @FXML
        public void onType(KeyEvent e){
            if (e.getSource().equals(text1)) {
                text2.setText("");
            } else {
                text1.setText("");
            }
        }
        private void resetText () {
            ableTextField();
            text1.setText("");
            text2.setText("");
        }
        private void ableTextField () {
            text1.setDisable(false);
            text2.setDisable(false);
        }
    }
