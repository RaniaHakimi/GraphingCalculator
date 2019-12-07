/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorraniasebtung;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sebastian Brann-Singer
 */
public class CalculatorMain extends Application {

    protected static CalculatorOperationsPane calculatorOperationPane = new CalculatorOperationsPane();
    protected static CalculatorMenuBar menuBar = new CalculatorMenuBar();
    
    @Override
    public void start(Stage stage) throws Exception {

        //create autosave.dat if it does not exist (first time running application)
        File saveFile = new File("autosave.dat");
        //creates file 
        if (!saveFile.createNewFile()){ //if it does not exist already
             //load autosave
            Save.autoload();
            
        }
        
        VBox container = new VBox();
        container.getChildren().addAll(menuBar,calculatorOperationPane);
        
        Scene scene = new Scene(container, 750, 500);
        stage.setTitle("Graphing Calculator"); // Set the window title
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Integer[] intList = {7, 8, 7, 7, 6, 1, 5, 6, 4, 9, 13, 11, 10, 16, 17};
//        List<Integer> testList = Arrays.asList(intList);
//
//        System.out.println("This is the mean: " + StatisticsOperations.findMean(testList));
//        System.out.println("This is the median: " + StatisticsOperations.findMedian(testList));
//        System.out.println("This is the mode " + StatisticsOperations.findMode(testList));
//
//        CubicEq function = new CubicEq();
//        function.setFunction(-1, -6, 11, -6);
//        System.out.println(function.findRoots());
//        
//        CubicEq function2 = new CubicEq();
//        function2.setFunction(1, -5, 3, -6);
//        System.out.println(function2.findRoots());
//        
//        CubicEq function3 = new CubicEq();
//        function3.setFunction(1, 0, -2, 0);
//        System.out.println(function3.findRoots());
//        
//        CubicEq function4 = new CubicEq();
//        function4.setFunction(1, 0, 0, 9);
//        System.out.println(function4.findRoots());

        launch(args);
    }

}
