package at.fhj.msd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    private Pane background;


    /**
     * Calulate the postfix expression and show the result in the text area
     * @param event
     */
    @FXML
    void btn_onClick_calc(ActionEvent event) {
      try {
            PostFixCalculator calc = new PostFixCalculator();
            String result = calc.calculatePostFix(tf_postfix.getText());
            tf_calculated.setText(result);
          
      } catch (ArithmeticException e) {
            tf_calculated.setText("Error\n \nDivision by 0");
      } catch (IllegalArgumentException e) {
            tf_calculated.setText("Error\n \nInvalid character in expression");      
      }
      catch (Exception e) {
                  tf_calculated.setText("Error\n \nSyntax");      
      }
   }

    /**
     * Convert the infix expression to postfix and show the result in the text area
     * @param event
     */
    @FXML
    void btn_onClick_in_to_post(ActionEvent event) {
      try {
            PostFixCalculator calc = new PostFixCalculator();
            String result = calc.convertInfixToPostfix(tf_postfix.getText());
            tf_calculated.setText(result);
      }  catch (ArithmeticException e) {
            tf_calculated.setText("Error\n \nDivision by 0");
      } catch (IllegalArgumentException e) {
            tf_calculated.setText("Error\n \nInvalid character in expression");      
      }
      catch (Exception e) {
                  tf_calculated.setText("Error\n \nSyntax");      
      }
    }

      /**
      * Convert the postfix expression to infix and show the result in the text area
      * @param event
      */
    @FXML
    void btn_onClick_post_to_in(ActionEvent event) {
      try {
            PostFixCalculator calc = new PostFixCalculator();
            String result = calc.convertPostfixToInfix(tf_postfix.getText());
            tf_calculated.setText(result);
      }  catch (ArithmeticException e) {
            tf_calculated.setText("Error\n \nDivision by 0");
      } catch (IllegalArgumentException e) {
            tf_calculated.setText("Error\n \nInvalid character in expression");      
      }
      catch (Exception e) {
                  tf_calculated.setText("Error\n \nSyntax");      
      }

    }
}