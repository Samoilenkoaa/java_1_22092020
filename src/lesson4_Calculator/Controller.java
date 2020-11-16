package lesson4_Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    public javafx.scene.control.TextArea textArea;
    Сalculator calculator = new Сalculator();
    boolean newNum = false;



    public void onClickBtnNum(ActionEvent actionEvent) {
        if (newNum){
            textArea.setText("");
            newNum = false;
        }
        textArea.appendText(((Button)actionEvent.getSource()).getText());
    }

    public void onClickBtmZnak(ActionEvent actionEvent) {
        String text = (((Button)actionEvent.getSource()).getText());
        if(text.equals("C")) {
            textArea.setText("");
            calculator.clear();
        }else if(text.equals("=")){
            calculator.num2 = Long.parseLong(textArea.getText());
            textArea.setText(String.valueOf(calculator.calculate()));
        }else{
            calculator.num1 = Long.parseLong(textArea.getText());
            calculator.operation = text;
            newNum = true;


        }

    }
}
