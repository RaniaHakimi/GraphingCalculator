package graphingcalculatorraniasebtung;

import java.util.HashMap;
import javafx.scene.control.TabPane;

public class CalculatorOperationsPane extends TabPane {

    protected static HashMap<String, String> tFContent = new HashMap();

    CalculatorOperationsPane() {

        ArithmeticOperationTab arithmeticOperationTab = new ArithmeticOperationTab();
        GeometricOperationTab geometricOperationTab = new GeometricOperationTab();
        EquationTab equationTab = new EquationTab();
        StatisticsOperationTab statisticsOperationTab = new StatisticsOperationTab();
        BarTab barTab = new BarTab();
        GraphTab graphTab = new GraphTab();

        getTabs().addAll(arithmeticOperationTab, geometricOperationTab, equationTab, statisticsOperationTab, barTab, graphTab);

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
