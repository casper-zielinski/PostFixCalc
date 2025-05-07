package at.fhj.msd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainSceneController {

    @FXML
    private Button btn_calc;

    @FXML
    private TextField tf_calculated;

    @FXML
    private TextField tf_postfix;

    @FXML
    void btn_onClick_calc(ActionEvent event) {
      PostFixCalculator calc = new PostFixCalculator();
      String result = calc.calculatePostFix(tf_postfix.getText());
      tf_calculated.setText(result);
    }

}