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
public class GeometricOperationTab extends Tab {

    private HashMap<String, String> tFContent = new HashMap();
    // 5 Text Fields for tab2
    private TextField tfSide = new TextField();
    private TextField tfNumberOfSides = new TextField();
    private TextField tfPolygonResult = new TextField();
    private TextField tfRadius = new TextField();
    private TextField tfCircleResult = new TextField();

    GeometricOperationTab() {
        // Design Tab2
        Tab tab2 = new Tab("Geometric Operations");
        // HBox for Polygon
        HBox hBoxPolygon = new HBox();
        tfSide.setPrefColumnCount(10);
        tfNumberOfSides.setPrefColumnCount(10);
        tfPolygonResult.setPrefColumnCount(10);
        hBoxPolygon.getChildren().addAll(new Label("Enter the length of a side:"), tfSide,
                new Label("Enter the number ofsides:"), tfNumberOfSides, new Label("Result:"), tfPolygonResult);
        Button btPerimeterOfPolygon = new Button("Calculate the perimeter");
        Button btAreaOfPolygon = new Button("Calculate the area");
        btPerimeterOfPolygon.setOnAction(e -> {
            String sideLength = tfSide.getText();
            String numberOfSides = tfNumberOfSides.getText();
            double result = GeometricOperations.perimeterOfPolygon(Integer.parseInt(sideLength),
                    Integer.parseInt(numberOfSides));
            tfPolygonResult.setText(result + "");
        });
        btAreaOfPolygon.setOnAction(e -> {
            String sideLength = tfSide.getText();
            String numberOfSides = tfNumberOfSides.getText();
            double result = GeometricOperations.areaOfPolygon(Integer.parseInt(sideLength),
                    Integer.parseInt(numberOfSides));
            tfPolygonResult.setText(result + "");
        });
        HBox hBoxPolygonButton = new HBox();
        hBoxPolygonButton.getChildren().addAll(btPerimeterOfPolygon, btAreaOfPolygon);
        VBox vBoxPolygon = new VBox();
        vBoxPolygon.getChildren().addAll(hBoxPolygon, hBoxPolygonButton);

        // HBox for Circle
        HBox hBoxCircle = new HBox();
        tfRadius.setPrefColumnCount(10);
        tfCircleResult.setPrefColumnCount(10);
        hBoxCircle.getChildren().addAll(new Label("Enter the length of the radius:"), tfRadius, new Label("Result:"),
                tfCircleResult);
        Button btPerimeterOfCircle = new Button("Calculate the perimeter");
        Button btAreaOfCircle = new Button("Calculate the area");
        btPerimeterOfCircle.setOnAction(e -> {
            String radius = tfRadius.getText();
            double result = GeometricOperations.perimeterOfCircle(Integer.parseInt(radius));
            tfCircleResult.setText(result + "");
        });
        btAreaOfCircle.setOnAction(e -> {
            String radius = tfRadius.getText();
            double result = GeometricOperations.areaOfCircle(Integer.parseInt(radius));
            tfCircleResult.setText(result + "");
        });
        HBox hBoxCircleButton = new HBox();
        hBoxCircleButton.getChildren().addAll(btPerimeterOfCircle, btAreaOfCircle);
        VBox vBoxCircle = new VBox();
        vBoxCircle.getChildren().addAll(hBoxCircle, hBoxCircleButton);

        VBox vBox2 = new VBox(10);
        vBox2.getChildren().addAll(vBoxPolygon, vBoxCircle);
        StackPane pane2 = new StackPane();
        pane2.getChildren().add(vBox2);
        tab2.setContent(pane2);
    }
    
    
}
