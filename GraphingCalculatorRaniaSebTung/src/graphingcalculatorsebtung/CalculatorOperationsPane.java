package graphingcalculatorsebtung;


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
import javafx.stage.Stage;

public class CalculatorOperationsPane extends Application {

    private HashMap<String, String> tFContent = new HashMap();
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

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        // Creating a Tab Pane
        TabPane tabPane = new TabPane();
        // Design for Tab1
        // hBox1 for Expression and Result
        // hBox2 for Calculate button
        // Add hBox 1 and hBox 2 in vBox
        // Add vBox into Pane 1
        // Add Pane1 into tab 1
        Tab tab1 = new Tab("Arithmetic Operations");
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
        tab1.setContent(pane1);

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

        // Tab 3 Design
        Tab tab3 = new Tab("Equations");
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
        StackPane pane3 = new StackPane();
        tab3.setContent(hBoxQuadratic);

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

        // Tab 5 Design
        Tab tab5 = new Tab("Graphs");
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
        tab5.setContent(vBox5);

        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5);

        Scene scene = new Scene(tabPane, 750, 500);
        primaryStage.setTitle("Graphing Calculator"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window
    }

    //save calculator //load calculator
    
    
    
    //setters and getters for textfields (accessed by save features)
    
    public HashMap<String, String> getTFContent(){
        //recieveUpdatedTFs()
        receiveTab1UpdatedTFs();
        return tFContent;
    }
    
    public void setTFContent(HashMap<String, String> saveData){
        //initializeTFs
        this.tFContent = saveData;
    }
    
    private void receiveAllUpdatedTFs(){
        receiveTab1UpdatedTFs();
         receiveTab2UpdatedTFs();
          receiveTab3UpdatedTFs();
           receiveTab4UpdatedTFs();
            receiveTab5UpdatedTFs();
    }
    
    private void initializeTFs(){
        
    }
    
    
    
    
    
    
    
    
    
    // 2 Text field for tab 1
    private void receiveTab1UpdatedTFs() {
        tFContent.put("tfExpression", tfExpression.getText());
        tFContent.put("tfResult", tfResult.getText());
    }

    // 5 Text Fields for tab2
    public void receiveTab2UpdatedTFs() {
        tFContent.put("tfSide", tfSide.getText());
        tFContent.put("tfNumberOfSides", tfNumberOfSides.getText());
        tFContent.put("tfPolygonResult", tfPolygonResult.getText());
        tFContent.put("tfRadius", tfRadius.getText());
        tFContent.put("tfCircleResult", tfCircleResult.getText());
    }
    
    // 4 Text field for tab3
    public void receiveTab3UpdatedTFs() {
        tFContent.put("tfa", tfa.getText());
        tFContent.put("tfb", tfb.getText());
        tFContent.put("tfc", tfc.getText());
        tFContent.put("tfQuadraticRoots", tfQuadraticRoots.getText());
    }
    
    // 8 Text fields for tab 4
    public void receiveTab4UpdatedTFs() {
        tFContent.put("tfMeanExpression", tfMeanExpression.getText());
        tFContent.put("tfMeanResult", tfMeanResult.getText());
        tFContent.put("tfMedianExpression", tfMedianExpression.getText());
        tFContent.put("tfMedianResult", tfMedianResult.getText());
        tFContent.put("tfModeExpression", tfModeExpression.getText());
        tFContent.put("tfModeResult", tfModeResult.getText());
        tFContent.put("tfPatternDeviationExpression", tfPatternDeviationExpression.getText());
        tFContent.put("tfPatternDeviationResult", tfPatternDeviationResult.getText());
    }

    // Text field for tab 5
    public void receiveTab5UpdatedTFs() {
        tFContent.put("tfBarGraphInput", tfBarGraphInput.getText());
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line. line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
