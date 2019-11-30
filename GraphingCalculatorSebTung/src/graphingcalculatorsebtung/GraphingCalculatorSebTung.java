/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorsebtung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sebastian Brann-Singer
 */
public class GraphingCalculatorSebTung extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] intList = {7, 8, 7, 7, 6, 1, 5, 6, 4, 9, 13, 11, 10, 16, 17};
        List<Integer> testList = Arrays.asList(intList);

        System.out.println("This is the mean: " + StatisticsOperations.findMean(testList));
        System.out.println("This is the median: " + StatisticsOperations.findMedian(testList));
        System.out.println("This is the mode " + StatisticsOperations.findMode(testList));

        launch(args);
    }

}
