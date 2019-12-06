/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphingcalculatorraniasebtung;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Brann-Singer & Rania Hakimi
 */
public class CubicEq {

    private double a, b, c, d, discriminant;
    //find critical #s

    //if f(c1) * f(c2) <0
    //3 roots
    //else 1 root
    public void setFunction(double a, double b, double c, double d) {
        if (a == 0){
            throw new IllegalArgumentException("a cannot be 0!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        discriminant = b * b - 3 * a * c;
    }

    public double evaluateFunction(double x) {
        return a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
    }

    public int findAmountOfCriticalNumbers() {
        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public ArrayList<Double> findCriticalNumbers() {
        ArrayList<Double> criticalNumbers = new ArrayList();
        int amountOfCriticalNumbers = findAmountOfCriticalNumbers();

        if (amountOfCriticalNumbers == 2) {
            //solve with both positive and negative discriminant
            criticalNumbers.add((-b - Math.sqrt(discriminant)) / 3 * a);
            criticalNumbers.add((-b + Math.sqrt(discriminant)) / 3 * a);

            // else if (amountOfCriticalNumbers == 1){
            //    criticalNumbers.add(-b / 3*a);
        }
        //if no critical numbers
        //solve for 1 root
        return criticalNumbers;

    }

    //finds the roots of a cubic function
    public ArrayList<Double> findRoots() {
        ArrayList<Double> roots = new ArrayList();
        //find critical #s
        ArrayList<Double> criticalNumbers = findCriticalNumbers();
        if (criticalNumbers.size() < 2) { //1 root
            roots.add(findRoot(-500.0, 500.0));
        } else {
            //if f(c1) * f(c2) < 0 (one is positive and one is negative)
            if ((evaluateFunction(criticalNumbers.get(0)) * evaluateFunction(criticalNumbers.get(1)) < 0)) {
                //3 roots
                roots.add(findRoot(-100.0, criticalNumbers.get(0)));
                roots.add(findRoot(criticalNumbers.get(0), criticalNumbers.get(1)));
                roots.add(findRoot(criticalNumbers.get(1), 100.0));
            } else {
                //solve for 1 root
                if (a > 0) { //leading term is positive
                    if (evaluateFunction(criticalNumbers.get(1)) < 0) { //critical numbers are negative
                        roots.add(findRoot(criticalNumbers.get(1), 500.0));
                    } else { //critical numbers are negative
                        roots.add(findRoot(-500.0, criticalNumbers.get(0)));
                    }
                } else { //leading term is negative
                    if (evaluateFunction(criticalNumbers.get(1)) < 0) { //critical numbers are negative

                        roots.add(findRoot(-500.0, criticalNumbers.get(0)));
                    } else { //critical numbers are negative
                        roots.add(findRoot(criticalNumbers.get(1), 500.0));
                    }
                }
            }
        }
        return roots;
    }

    //finds a root on an interval
    public Double findRoot(Double x1, Double x2) {
        double y1 = evaluateFunction(x1);
        //System.out.println("This is the value of f(" + x1 + "): " + y1);
        double y2 = evaluateFunction(x2);
        //System.out.println("This is the value of f(" + x2 + "): " + y2);
        double xIntercept = x1;
        final int MAX_ITERATIONS = 1000000; //numbers of iterations to get higher precision
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            if (evaluateFunction(x1) * evaluateFunction(x2) >= 0) {

                //
                // System.out.println("Both positive or negative");
                //if (evaluateFunction(x1) > 0 && a > 0) {
                //    x2 -= 200;
                //}
                //no root on this interval
                //if one of the is positive
            } else if (evaluateFunction(x1) * evaluateFunction(x2) < 0) {
                //xIntercept = (x1+x2)/2;
                xIntercept = (x1 * evaluateFunction(x2) - x2 * evaluateFunction(x1))
                        / (evaluateFunction(x2) - evaluateFunction(x1));
                //System.out.println("The x intercept between " + x1 + " and " + x2 + " is " + xIntercept);
                //double midpointy= (y1+y2)/2;

                if (evaluateFunction(xIntercept) == 0) {
                    //System.out.println("A root of this function is " + xIntercept);
                    return xIntercept;
                } else if (evaluateFunction(xIntercept) * evaluateFunction(x1) < 0) {
                    x2 = xIntercept;
                } else {
                    x1 = xIntercept;
                }

            }

        }
        return xIntercept;
    }
}
