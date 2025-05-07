package at.fhj.msd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainSceneController {

    @FXML
    private Button btn_calc;

    @FXML
    private Button btn_in_to_post;

    @FXML
    private Button btn_post_to_in;

    @FXML
    private TextArea tf_calculated;

    @FXML
    private TextField tf_postfix;

    @FXML
    private Label lb_text;

    @FXML
    private Label lb_mathprint;

    @FXML
    void btn_onClick_calc(ActionEvent event) {
      try {
            PostFixCalculator calc = new PostFixCalculator();
            String result = calc.calculatePostFix(tf_postfix.getText());
            tf_calculated.setText(result);
          
      } catch (Exception e) {
            tf_calculated.setText("Error\n \nSyntax");
      }
      
    }

    @FXML
    void btn_onClick_in_to_post(ActionEvent event) {
      try {
            PostFixCalculator calc = new PostFixCalculator();
            String result = calc.convertInfixToPostfix(tf_postfix.getText());
            tf_calculated.setText(result);
      } catch (Exception e) {
            tf_calculated.setText("Error\n \nSyntax");
      }
    }

    @FXML
    void btn_onClick_post_to_in(ActionEvent event) {
      try {
            PostFixCalculator calc = new PostFixCalculator();
            String result = calc.convertPostfixToInfix(tf_postfix.getText());
            tf_calculated.setText(result);
      } catch (Exception e) {
            tf_calculated.setText("Error\n \nSyntax");
      }
    }

}