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
    CubicEq cubicFunction = new CubicEq();
    // 8 Text field for tab3
    private static TextField tfa = new TextField();
    private static TextField tfb = new TextField();
    private static TextField tfc = new TextField();
    private static TextField tfQuadraticRoots = new TextField();

    
    private static TextField tfa2 = new TextField();
    private static TextField tfb2 = new TextField();
    private static TextField tfc2 = new TextField();
    private static TextField tfd2 = new TextField();
    private static TextField tfCubicRoots = new TextField();
    
    EquationTab() {
        // Tab 3 Design
        super("Equations");
        HBox hBoxQuadratic = new HBox();
        HBox hBoxQuadraticInputs = new HBox();
        HBox hBoxQuadraticOutputs = new HBox();
        HBox hBoxCubic = new HBox();
        HBox hBoxCubicInputs = new HBox();
        HBox hBoxCubicOutputs = new HBox();
        
        
        tfa.setPrefColumnCount(5);
        tfb.setPrefColumnCount(5);
        tfc.setPrefColumnCount(5);
        tfQuadraticRoots.setPrefColumnCount(10);
        hBoxQuadraticInputs.getChildren().addAll( tfa, new Label(" x\u00B2 + "), tfb,
                new Label(" x + "), tfc,new Label(" = 0"));
        Button btQuadraticRoots = new Button("Find the roots");
        btQuadraticRoots.setOnAction(e -> {
            String a = tfa.getText();
            String b = tfb.getText();
            String c = tfc.getText();
            ArrayList result = Equations.quadraticRoots(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c));
            tfQuadraticRoots.setText(result + "");
        });
        
        
        hBoxQuadraticOutputs.getChildren().addAll( btQuadraticRoots,tfQuadraticRoots);
        hBoxQuadratic.getChildren().addAll(hBoxQuadraticInputs, hBoxQuadraticOutputs);
        tfa2.setPrefColumnCount(5);
        tfb2.setPrefColumnCount(5);
        tfc2.setPrefColumnCount(5);
        tfd2.setPrefColumnCount(5);
        //tfQuadraticRoots.setPrefColumnCount(10);
        
        //Char xPower3 = 'U+00B3';
        hBoxCubicInputs.getChildren().addAll( tfa2, new Label(" x\u00B3 + "), tfb2,
                new Label(" x\u00B2 + "), tfc2, new Label(" x + "), tfd2,new Label(" = 0"));
        
        Button btCubicRoots = new Button("Find the roots");
        btCubicRoots.setOnAction(e -> {
            String a2 = tfa2.getText();
            
            String b2 = tfb2.getText();
            String c2 = tfc2.getText();
            String d2 = tfd2.getText();
            System.out.println(a2 + b2 + c2 + d2);
            cubicFunction.setFunction(Double.parseDouble(a2), Double.parseDouble(b2), Double.parseDouble(c2),Double.parseDouble(d2));
            ArrayList result = cubicFunction.findRoots();
            tfCubicRoots.setText(result + "");
        });
        
        hBoxCubicOutputs.getChildren().addAll( btCubicRoots,tfCubicRoots);
        hBoxCubic.getChildren().addAll(hBoxCubicInputs,hBoxCubicOutputs);
        
        VBox vBox3 = new VBox();
        vBox3.getChildren().addAll(hBoxQuadratic,hBoxCubic);
        //StackPane pane3 = new StackPane();
        setContent(vBox3);
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
