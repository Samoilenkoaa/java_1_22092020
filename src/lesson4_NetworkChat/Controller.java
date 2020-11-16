package lesson4_NetworkChat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    public javafx.scene.control.TextArea textArea;
    @FXML
    public javafx.scene.control.TextField textField;


    public void onClickBtn(ActionEvent actionEvent) {
        textArea.appendText(textField.getText() + " \n");
        textField.clear();

    }

    public void onKeyTyped(KeyEvent keyEvent) {
        if (keyEvent.getCharacter().contains("\r")){
            textArea.appendText(textField.getText() + " \n");
            textField.clear();

        }
    }
}
