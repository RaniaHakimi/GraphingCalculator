/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorsebtung;

import java.lang.Math;

/**
 *
 * @author mrbea
 */
abstract class GeometricObject {

    public GeometricObject() {
    }

    public abstract double getPerimeter();

    public abstract double getArea();

}

class Polygon extends GeometricObject {

    private double sideLength;
    private int numberOfSides;

    public int getNumberOfSides() {
        return numberOfSides;
    }
    
    public void setNumberOfSides(int numSides){
        this.numberOfSides = numSides;
    }
    
    public double getSideLength(){
        return sideLength;
    }
    
    public void setSideLength(double length){
        this.sideLength = length;
    }
  
    public double getPerimeter() {
        return sideLength * numberOfSides;
    }

    public double getArea() {
        return ((sideLength * sideLength) * numberOfSides) / (4 * Math.tan(180 / numberOfSides));
    }
}


abstract class Circle extends GeometricObject{
    private double radius;

    
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double rad){
        this.radius = rad;
    }
  
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }
    
}
