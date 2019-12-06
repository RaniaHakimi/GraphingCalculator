package graphingcalculatorsebtung;

public class GeometricOperations {
	GeometricOperations() {

	}
	// Get area and perimeter of any regular polygon
	public static double perimeterOfPolygon(double s, int n) {
		double perimeter = 0;
		perimeter = s * n;
		return perimeter;
	}

	public static double areaOfPolygon(double s, int n) {
		double area = 0;
		double angle = Math.tan(Math.toRadians(180 / n));
		area = ((s * s * n) / (4 * angle));
		return area;
	}

	// get area and perimeter of any regular polygon
	public static double areaOfCircle(double r) {
		double area = 0;
		area = Math.pow(r, 2) * Math.PI;
		return area;
	}

	public static double perimeterOfCircle(double r) {
		double perimeter = 0;
		perimeter = 2 * r * Math.PI;
		return perimeter;
	}

}
