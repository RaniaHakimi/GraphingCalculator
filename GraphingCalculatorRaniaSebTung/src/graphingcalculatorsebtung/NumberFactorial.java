/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorsebtung;

/**
 *
 * @author mrbea
 */
public class NumberFactorial{

    int number;
    int fact;

    public int factorial() {

        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
    
    public void setNumber(int num){
        this.number = num;
    }
    
    public int getNumber(){
        return fact;
    }
}
