/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorraniasebtung;

import java.util.HashMap;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author mrbea
 */
public class BarTab extends Tab {
    // Text field for tab 5

    protected static TextField tfBarGraphInput = new TextField();

    BarTab() {
        // Tab 5 Design
        super("Graphs");
        VBox vBox5 = new VBox();

        tfBarGraphInput.setPrefColumnCount(10);
        Button btBarGraph = new Button("Show Graph");

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Data Numbers");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Numbers");
        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series dataSeries = new XYChart.Series();
        btBarGraph.setOnAction(e -> {
            int[] array = BarGraph.StringToArray(tfBarGraphInput.getText());
            for (int i = 0; i < array.length; i++) {
                dataSeries.getData().add(new XYChart.Data(Integer.toString(i + 1), array[i]));
            }
            // dataSeries.setName("Set of Integers");
            barChart.getData().add(dataSeries);
        });
        VBox vBoxBarGraphInputs = new VBox();
        vBoxBarGraphInputs.getChildren().addAll(tfBarGraphInput, btBarGraph);
        VBox vBoxBarGraph = new VBox();
        vBoxBarGraph.getChildren().add(barChart);
        HBox hBoxBarGraph = new HBox();

        hBoxBarGraph.getChildren().addAll(vBoxBarGraphInputs, vBoxBarGraph);

        vBox5.getChildren().add(hBoxBarGraph);
        setContent(vBox5);
    }

    protected static void receiveUpdatedTFs() {
        CalculatorOperationsPane.tFContent.put("tfBarGraphInput", tfBarGraphInput.getText());
    }

    protected static void initializeTFs() {
        tfBarGraphInput.setText(CalculatorOperationsPane.tFContent.get("tfBarGraphInput"));
    }
}
