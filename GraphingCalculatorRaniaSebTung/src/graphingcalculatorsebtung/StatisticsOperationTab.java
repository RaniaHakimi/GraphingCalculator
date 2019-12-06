/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorsebtung;

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
public class StatisticsOperationTab extends Tab {

    private HashMap<String, String> tFContent = new HashMap();

    // 8 Text fields for tab 4
    private TextField tfMeanExpression = new TextField();
    private TextField tfMeanResult = new TextField();
    private TextField tfMedianExpression = new TextField();
    private TextField tfMedianResult = new TextField();
    private TextField tfModeExpression = new TextField();
    private TextField tfModeResult = new TextField();
    private TextField tfPatternDeviationExpression = new TextField();
    private TextField tfPatternDeviationResult = new TextField();

    StatisticsOperationTab() {
        // Tab 4 Design
        // 2 Hbox for Mean in 1 vbox
        // 2 Hbox for Median in 1 vbox
        // 2 Hbox for Mode in 1 vbox
        // 2 Hbox for Pattern Deviation in 1 vbox
        // 4 VBox in one VBox
        // 1 VBox in pane 4
        // pane 4 in tab 4
        Tab tab4 = new Tab("Statistics");
        // Hbox for mean
        HBox hBoxMean = new HBox();
        tfMeanExpression.setPrefColumnCount(10);
        tfMeanResult.setPrefColumnCount(10);
        hBoxMean.getChildren().addAll(new Label("Enter a set of integers:"), tfMeanExpression, new Label("Result:"),
                tfMeanResult);
        Button btCalculateMean = new Button("Calculate Mean");
        btCalculateMean.setOnAction(e -> {
            String str = tfMeanExpression.getText();
            double result = Statistics.calculateMean(str);
            tfMeanResult.setText(result + "");
        });
        HBox hBoxMeanButton = new HBox();
        hBoxMeanButton.getChildren().add(btCalculateMean);
        VBox vBoxmean = new VBox();
        vBoxmean.getChildren().addAll(hBoxMean, hBoxMeanButton);

        // HBox for Median
        HBox hBoxMedian = new HBox();
        tfMedianExpression.setPrefColumnCount(10);
        tfMedianResult.setPrefColumnCount(10);
        hBoxMedian.getChildren().addAll(new Label("Enter a set of integers:"), tfMedianExpression, new Label("Result:"),
                tfMedianResult);
        Button btCalculateMedian = new Button("Calculate Median");
        btCalculateMedian.setOnAction(e -> {
            String str = tfMedianExpression.getText();
            double result = Statistics.calculateMedian(str);
            tfMedianResult.setText(result + "");
        });
        HBox hBoxMedianButton = new HBox();
        hBoxMedianButton.getChildren().add(btCalculateMedian);
        VBox vBoxMedian = new VBox();
        vBoxMedian.getChildren().addAll(hBoxMedian, hBoxMedianButton);

        // HBox for Mode
        HBox hBoxMode = new HBox();
        tfModeExpression.setPrefColumnCount(10);
        tfModeResult.setPrefColumnCount(10);
        hBoxMode.getChildren().addAll(new Label("Enter a set of integers:"), tfModeExpression, new Label("Result:"),
                tfModeResult);
        Button btCalculateMode = new Button("Calculate Mode");
        btCalculateMode.setOnAction(e -> {
            String str = tfModeExpression.getText();
            double result = Statistics.calculateMode(str);
            tfModeResult.setText(result + "");
        });
        HBox hBoxModeButton = new HBox();
        hBoxModeButton.getChildren().add(btCalculateMode);
        VBox vBoxMode = new VBox();
        vBoxMode.getChildren().addAll(hBoxMode, hBoxModeButton);

        // HBox for Pattern Deviation
        HBox hBoxPatternDeviation = new HBox();
        tfPatternDeviationExpression.setPrefColumnCount(10);
        tfPatternDeviationResult.setPrefColumnCount(10);
        hBoxPatternDeviation.getChildren().addAll(new Label("Enter a set of integers:"), tfPatternDeviationExpression,
                new Label("Result:"), tfPatternDeviationResult);
        Button btCalculatePatternDeviation = new Button("Calculate Pattern Deviation");
        btCalculatePatternDeviation.setOnAction(e -> {
            String str = tfPatternDeviationExpression.getText();
            double result = Statistics.calculateStandardDeviation(str);
            tfPatternDeviationResult.setText(result + "");
        });
        HBox hBoxPatternDeviationButton = new HBox();
        hBoxPatternDeviationButton.getChildren().add(btCalculatePatternDeviation);
        VBox vBoxPatternDeviation = new VBox();
        vBoxPatternDeviation.getChildren().addAll(hBoxPatternDeviation, hBoxPatternDeviationButton);

        VBox vBox4 = new VBox();
        vBox4.getChildren().addAll(vBoxmean, vBoxMedian, vBoxMode, vBoxPatternDeviation);
        StackPane pane4 = new StackPane();
        pane4.getChildren().add(vBox4);
        tab4.setContent(pane4);
    }
}
