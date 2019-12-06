package graphingcalculatorraniasebtung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mrbea
 */

public class ArithmeticOperationTab extends Tab{
    
    private HashMap<String, String> tFContent = new HashMap();
    // 2 Text field for tab 1
    private TextField tfExpression = new TextField();
    private TextField tfResult = new TextField();
    
    ArithmeticOperationTab(){
        // hBox1 for Expression and Result
        // hBox2 for Calculate button
        // Add hBox 1 and hBox 2 in vBox
        // Add vBox into Pane 1
        // Add Pane1 into tab 1
        super("Arithmetic Operations");
        StackPane pane1 = new StackPane();
        HBox hBox1 = new HBox(30);
        tfExpression.setPrefColumnCount(10);
        tfResult.setPrefColumnCount(10);
        hBox1.getChildren().addAll(new Label("Enter an expression:"), tfExpression, new Label("Result:"), tfResult);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(20);
        Button btCalculate = new Button("Calculate");
        btCalculate.setOnAction(e -> {
            String str = tfExpression.getText();
            double result = EvaluateExpression.evaluateExpression(str);
            tfResult.setText(result + "");
        });
        hBox2.getChildren().addAll(btCalculate);
        hBox2.setAlignment(Pos.CENTER);
        VBox vBox1 = new VBox(10);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(hBox1, hBox2);
        pane1.getChildren().addAll(vBox1);
        setContent(pane1);
    }
    
    private void receiveUpdatedTFs() {
        tFContent.put("tfExpression", tfExpression.getText());
        tFContent.put("tfResult", tfResult.getText());
    }

    private void initializeTFs() {
        tfExpression.setText(tFContent.get("tfExpression"));
        tfResult.setText(tFContent.get("tfResult"));
    }
    
    public HashMap<String, String> getTFContent() {
        receiveUpdatedTFs(); //gets most recent content in TFs
        return tFContent;
    }

    //for loading
    public void setTFContent(HashMap<String, String> saveData) { //may need to be updated
        this.tFContent = saveData;
        initializeTFs(); //initializes all TFs with savedata
    }
    

    
}
