/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorraniasebtung;

/**
 *
 * @author Sebastian Brann-Singer
 */
public class DrawGraph {
    private String function; //function recieved from textfield
    private String expression; //expression that independant var modifies (for now, right side of = )
    //maybe input can look like this f([dependantVar]) = [          ]
    private char dependantVar; //var recieved on left side of = (inside f[ ])
    private char independantVar; //var contained inside expression (if doesnt exist, set to equal 0)
    
    
    //determines independantVar
    private void setIndependantVar(char c){
        this.independantVar = c;
    }
    
    //gets textfield data that has been set to lowercase
    public void initializeDependantVar(String leftInput) throws IllegalArgumentException {
        if (leftInput.length() > 1){
            throw new IllegalArgumentException("dependantVariable can only be one character");
        } else if (leftInput.contains("y") || leftInput.contains("x")){
            dependantVar = 'y';
        } else if (leftInput.contains("x")){
            dependantVar = 'x';
        } else {
            throw new IllegalArgumentException("dependantVariable can only be x or y ");
        }
    }
    
    public void findIndependantVar(){
        
        for (int i = 0; i < expression.length(); i++){
            
        }
       if ( expression.contains("x") || expression.contains("X")){
           independantVar = 'x';
       } 
    }
    
    //takes string (function) from textfield, determines the independant var, and isolates the expresion
    public void initializeExpression(String function){
        //ex: y = x^2 + x + 5 becomes:
        //function = x^2 + x + 5
        //independantVar = x
        
        
    }
    
    //maybe move this to another java file ex: graphUtilities.java
    // 
    private Double evaluateExpression(double value){
        //exchanges all instances of the independant variable with value
        //ex: y = 2x + 1, y is the depentant variable and x is the independant
        return null;
    }
    
    //draws lines on pane
    private void repaintGraph(){
        
    }
    
    
    
    
    
}
