package graphingcalculatorraniasebtung;

import java.util.ArrayList;

public class Equations {
	Equations(){
		
	}
	

	
	public static ArrayList quadraticRoots(int a, int b, int c) {
		ArrayList list = new ArrayList<>();
		double root1,root2;
		double discriminant = b*b-4*a*c;
		
		if (discriminant>0) {
			root1 = (-b+Math.sqrt(discriminant))/(2*a);
			root2 = (-b-Math.sqrt(discriminant))/(2*a);
			list.add(root1);
			list.add(root2);
		}
		else if (discriminant == 0) {
			root1=-b/(2*a);
			list.add(root1);
		} else 
			list.add("No real solutions");
		return list;
	}
	
	public static ArrayList cubicRoots(int a, int b, int c, int d) {
		ArrayList<Double> list = new ArrayList<Double>();
	        double[] result;
	        if (a != 1) {
	            b = b / a;
	            c = c / a;
	            d = d / a;
	        }
	        double p = c / 3 - b * b / 9;
	        double q = b * b * b / 27 - b * c / 6 + d / 2;
	        double D = p * p * p + q * q;

	        if (Double.compare(D, 0) >= 0) {
	            if (Double.compare(D, 0) == 0) {
	                double r = Math.cbrt(-q);
	                list.add(2 * r);
	                list.add(-r);
	            } else {
	                double r = Math.cbrt(-q + Math.sqrt(D));
	                double s = Math.cbrt(-q - Math.sqrt(D));
	                list.add(r + s);
	            }
	        } else {
	            double ang = Math.acos(-q / Math.sqrt(-p * p * p));
	            double r = 2 * Math.sqrt(-p);
	            result = new double[3];
	            for (int k = -1; k <= 1; k++) {
	                double theta = (ang - 2 * Math.PI * k) / 3;
	                list.add(r * Math.cos(theta));
	            }
	        }
	        for (Double e : list) {
	            e = e- b / 3;
	        }
	        return list;
	    
	}
	
}
