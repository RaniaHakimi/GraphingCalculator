/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorraniasebtung;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Save features for Graphing Calculator
 *
 * @author Sebastian Brann-Singer 12/6/19
 */
public class Save {

    public static void save(String filename) throws IOException {
        HashMap<String, String> calculatorSave = CalculatorMain.calculatorOperationPane.getTFContent();

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename));) {
            output.writeObject(calculatorSave);
        } //auto-closes file

    }

    public static void autosave() throws IOException {
        save("autosave.dat");
    }

    public static void load(String filename) throws IOException, ClassNotFoundException {
        //reads fred and barney from bin file and prints their toString
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));) {
            CalculatorMain.calculatorOperationPane.setTFContent((HashMap<String, String>) (input.readObject()));
        } //auto-closes file
    }

    public static void autoload() throws IOException, ClassNotFoundException {
        load("autosave.dat");
    }

}
