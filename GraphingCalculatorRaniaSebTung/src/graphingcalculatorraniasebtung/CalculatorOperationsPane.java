package graphingcalculatorraniasebtung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CalculatorOperationsPane extends TabPane {

    protected static HashMap<String, String> tFContent = new HashMap();
    // 2 Text field for tab 1
    private TextField tfExpression = new TextField();
    private TextField tfResult = new TextField();

    // 5 Text Fields for tab2
    private TextField tfSide = new TextField();
    private TextField tfNumberOfSides = new TextField();
    private TextField tfPolygonResult = new TextField();
    private TextField tfRadius = new TextField();
    private TextField tfCircleResult = new TextField();

    // 8 Text field for tab3
    private TextField tfa = new TextField();
    private TextField tfb = new TextField();
    private TextField tfc = new TextField();
    private TextField tfQuadraticRoots = new TextField();

    // 8 Text fields for tab 4
    private TextField tfMeanExpression = new TextField();
    private TextField tfMeanResult = new TextField();
    private TextField tfMedianExpression = new TextField();
    private TextField tfMedianResult = new TextField();
    private TextField tfModeExpression = new TextField();
    private TextField tfModeResult = new TextField();
    private TextField tfPatternDeviationExpression = new TextField();
    private TextField tfPatternDeviationResult = new TextField();

    // Text field for tab 5
    private TextField tfBarGraphInput = new TextField();

    CalculatorOperationsPane() {

        ArithmeticOperationTab arithmeticOperationTab = new ArithmeticOperationTab();
        GeometricOperationTab geometricOperationTab = new GeometricOperationTab();
        EquationTab equationTab = new EquationTab();
        StatisticsOperationTab statisticsOperationTab = new StatisticsOperationTab();
        BarTab barTab = new BarTab();
        
        
        getTabs().addAll(arithmeticOperationTab, geometricOperationTab, equationTab, statisticsOperationTab, barTab);

    }

    //save calculator //load calculator
    //setters and getters for textfields (accessed by save features)
    //for saving
    public HashMap<String, String> getTFContent() {
        receiveAllUpdatedTFs(); //gets most recent content in TFs
        return tFContent;
    }

    //for loading
    public void setTFContent(HashMap<String, String> saveData) {
        this.tFContent = saveData;
        initializeAllTFs(); //initializes all TFs with savedata
    }

    private void receiveAllUpdatedTFs() {
        receiveTab1UpdatedTFs();
        receiveTab2UpdatedTFs();
        receiveTab3UpdatedTFs();
        receiveTab4UpdatedTFs();
        receiveTab5UpdatedTFs();
    }

    private void initializeAllTFs() {
        ArithmeticOperationTab.initializeTFs();
        
        
        initializeTab1TFs();
        initializeTab2TFs();
        initializeTab3TFs();
        initializeTab4TFs();
        initializeTab5TFs();
    }

//    // 2 Text field for tab 1
//    private void receiveTab1UpdatedTFs() {
//        tFContent.put("tfExpression", tfExpression.getText());
//        tFContent.put("tfResult", tfResult.getText());
//    }
//
//    private void initializeTab1TFs() {
//        tfExpression.setText(tFContent.get("tfExpression"));
//        tfResult.setText(tFContent.get("tfResult"));
//    }
//
//    // 5 Text Fields for tab2
//    private void receiveTab2UpdatedTFs() {
//        tFContent.put("tfSide", tfSide.getText());
//        tFContent.put("tfNumberOfSides", tfNumberOfSides.getText());
//        tFContent.put("tfPolygonResult", tfPolygonResult.getText());
//        tFContent.put("tfRadius", tfRadius.getText());
//        tFContent.put("tfCircleResult", tfCircleResult.getText());
//    }
//
//    private void initializeTab2TFs() {
//        tfSide.setText(tFContent.get("tfSide"));
//        tfNumberOfSides.setText(tFContent.get("tfNumberOfSides"));
//        tfPolygonResult.setText(tFContent.get("tfPolygonResult"));
//        tfRadius.setText(tFContent.get("tfRadius"));
//        tfCircleResult.setText(tFContent.get("tfCircleResult"));
//    }
//
//    // 4 Text field for tab3
//    private void receiveTab3UpdatedTFs() {
//        tFContent.put("tfa", tfa.getText());
//        tFContent.put("tfb", tfb.getText());
//        tFContent.put("tfc", tfc.getText());
//        tFContent.put("tfQuadraticRoots", tfQuadraticRoots.getText());
//    }
//
//    private void initializeTab3TFs() {
//        tfa.setText(tFContent.get("tfa"));
//        tfb.setText(tFContent.get("tfb"));
//        tfc.setText(tFContent.get("tfc"));
//        tfQuadraticRoots.setText(tFContent.get("tfQuadraticRoots"));
//    }
//
//    // 8 Text fields for tab 4
//    private void receiveTab4UpdatedTFs() {
//        tFContent.put("tfMeanExpression", tfMeanExpression.getText());
//        tFContent.put("tfMeanResult", tfMeanResult.getText());
//        tFContent.put("tfMedianExpression", tfMedianExpression.getText());
//        tFContent.put("tfMedianResult", tfMedianResult.getText());
//        tFContent.put("tfModeExpression", tfModeExpression.getText());
//        tFContent.put("tfModeResult", tfModeResult.getText());
//        tFContent.put("tfPatternDeviationExpression", tfPatternDeviationExpression.getText());
//        tFContent.put("tfPatternDeviationResult", tfPatternDeviationResult.getText());
//    }
//
//    private void initializeTab4TFs() {
//        tfMeanExpression.setText(tFContent.get("tfMeanExpression"));
//        tfMeanResult.setText(tFContent.get("tfMeanResult"));
//        tfMedianExpression.setText(tFContent.get("tfMedianExpression"));
//        tfMedianResult.setText(tFContent.get("tfMedianResult"));
//        tfModeExpression.setText(tFContent.get("tfModeExpression"));
//        tfModeResult.setText(tFContent.get("tfModeResult"));
//        tfPatternDeviationExpression.setText(tFContent.get("tfPatternDeviationExpression"));
//        tfPatternDeviationResult.setText(tFContent.get("tfPatternDeviationResult"));
//    }
//
//    // Text field for tab 5
//    private void receiveTab5UpdatedTFs() {
//        tFContent.put("tfBarGraphInput", tfBarGraphInput.getText());
//    }
//
//    private void initializeTab5TFs() {
//        tfBarGraphInput.setText(tFContent.get("tfBarGraphInput"));
//    }

}
