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
    public static HashMap<String, String> getTFContent() {
        receiveAllUpdatedTFs(); //gets most recent content in TFs
        return tFContent;
    }

    //for loading
    public static void setTFContent(HashMap<String, String> saveData) {
        CalculatorOperationsPane.tFContent = saveData;
        initializeAllTFs(); //initializes all TFs with savedata
    }

    private static void receiveAllUpdatedTFs() {
        ArithmeticOperationTab.receiveUpdatedTFs();
        GeometricOperationTab.receiveUpdatedTFs();
        EquationTab.receiveUpdatedTFs();
        StatisticsOperationTab.receiveUpdatedTFs();
        BarTab.receiveUpdatedTFs();
    }

    private static void initializeAllTFs() {
        ArithmeticOperationTab.initializeTFs();
        GeometricOperationTab.initializeTFs();
        EquationTab.initializeTFs();
        StatisticsOperationTab.initializeTFs();
        BarTab.receiveUpdatedTFs();
    }

}
