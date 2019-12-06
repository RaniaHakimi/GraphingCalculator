/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorraniasebtung;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author mrbea
 */
public class EquationTab extends Tab{

    // 8 Text field for tab3
    private static TextField tfa = new TextField();
    private static TextField tfb = new TextField();
    private static TextField tfc = new TextField();
    private static TextField tfQuadraticRoots = new TextField();

    EquationTab() {
        // Tab 3 Design
        super("Equations");
        HBox hBoxQuadratic = new HBox();
        VBox vBoxQuadraticInputs = new VBox();
        VBox vBoxQuadraticOutputs = new VBox();
        tfa.setPrefColumnCount(5);
        tfb.setPrefColumnCount(5);
        tfc.setPrefColumnCount(5);
        tfQuadraticRoots.setPrefColumnCount(10);
        vBoxQuadraticInputs.getChildren().addAll(new Label("Enter a:"), tfa, new Label("Enter b:"), tfb,
                new Label("Enter c:"), tfc);
        Button btQuadraticRoots = new Button("Find the roots");
        btQuadraticRoots.setOnAction(e -> {
            String a = tfa.getText();
            String b = tfb.getText();
            String c = tfc.getText();
            ArrayList result = Equations.quadraticRoots(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c));
            tfQuadraticRoots.setText(result + "");
        });
        vBoxQuadraticOutputs.getChildren().addAll(tfQuadraticRoots, btQuadraticRoots);
        hBoxQuadratic.getChildren().addAll(vBoxQuadraticInputs, vBoxQuadraticOutputs);
        VBox vBox3 = new VBox();
        vBox3.getChildren().add(hBoxQuadratic);
        //StackPane pane3 = new StackPane();
        setContent(hBoxQuadratic);
    }
    
    protected static void receiveUpdatedTFs() {
        CalculatorOperationsPane.tFContent.put("tfa", tfa.getText());
        CalculatorOperationsPane.tFContent.put("tfb", tfb.getText());
        CalculatorOperationsPane.tFContent.put("tfc", tfc.getText());
        CalculatorOperationsPane.tFContent.put("tfQuadraticRoots", tfQuadraticRoots.getText());
    }

    protected static void initializeTFs() {
        tfa.setText(CalculatorOperationsPane.tFContent.get("tfa"));
        tfb.setText(CalculatorOperationsPane.tFContent.get("tfb"));
        tfc.setText(CalculatorOperationsPane.tFContent.get("tfc"));
        tfQuadraticRoots.setText(CalculatorOperationsPane.tFContent.get("tfQuaraticRoots"));
    }
    
 
}
