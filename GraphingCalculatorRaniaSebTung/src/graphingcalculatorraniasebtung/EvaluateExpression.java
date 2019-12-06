package graphingcalculatorraniasebtung;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Integer;
import java.lang.Math;

public class EvaluateExpression {

    EvaluateExpression() {

    }

    //public static void main(String[] args) {
    //Scanner scanner = new Scanner(System.in);
    //System.out.println("Enter an expression: ");
    //String input = scanner.nextLine();
    //System.out.println(evaluateExpression(input));
    //}
    // To evaluate an expression
    public static Double evaluateExpression(String expression) {
        // Creating operandStack to store operands
        Stack<Double> operandStack = new Stack<>();

        // Creating operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();
        expression = insertBlanks(expression);
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.length() == 0) {
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '%'
                        || operatorStack.peek() == '^')) {
                    processAnOperator(operandStack, operatorStack);
                }
                while (!operatorStack.isEmpty() && operatorStack.peek() == '!') {
                    processingFactorial(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '^') {
                while (!operatorStack.isEmpty() && operatorStack.peek() == '^') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '!') {
                while (!operatorStack.isEmpty() && operatorStack.peek() == '!') {
                    processingFactorial(operandStack, operatorStack);
                    System.out.println("Fuck");
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/'
                        || operatorStack.peek() == '%' || operatorStack.peek() == '!')) {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            } else {
                operandStack.push(Double.parseDouble(token));
            }
        }
        while (!operatorStack.isEmpty()) {
            if (operatorStack.contains('!')) {
                processingFactorial(operandStack, operatorStack);
            } else {
                processAnOperator(operandStack, operatorStack);
            }
        }
        return operandStack.pop();
    }

    public static void processAnOperator(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        double op1 = operandStack.pop();
        double op2 = operandStack.pop();

        if (op == '+') {
            operandStack.push(op2 + op1);
        } else if (op == '-') {
            operandStack.push(op2 - op1);
        } else if (op == '*') {
            operandStack.push(op2 * op1);
        } else if (op == '/') {
            operandStack.push(op2 / op1);
        } else if (op == '%') {
            operandStack.push(op2 % op1);
        } else if (op == '^') {
            operandStack.push(Math.pow(op2, op1));
        }
    }

    public static void processingFactorial(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        double op1 = operandStack.pop();
        if (op == '!') {
            operandStack.push(op1 * factorial(op1 - 1));
        }
    }

    public static String insertBlanks(String expression) {
        String result = "";

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == ')' || expression.charAt(i) == '+'
                    || expression.charAt(i) == '-' || expression.charAt(i) == '%' || expression.charAt(i) == '!'
                    || expression.charAt(i) == '^' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                result += " " + expression.charAt(i) + " ";
            } else {
                result += expression.charAt(i);
            }
        }
        return result;
    }

    static double factorial(double n) {
        int res = 1, i;
        for (i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
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

    public static void quadraticRoots(int a, int b, int c) {
        double root1, root2;
        double determinant = b * b - 4 * c * c;
        if (determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            System.out.println("The roots are " + root1 + " and " + root2);
        } else if (determinant == 0) {
            root1 = -b / (2 * a);
            System.out.println("The only root is " + root1);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }

    public static double calculateMean(int[] array) {
        double mean = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            mean = sum / array.length;
        }
        return mean;
    }

    public static int calculateMode(int[] array) {
        int maxValue = 0, maxCount = 0, i, j;
        for (i = 0; i < array.length; ++i) {
            int count = 0;
            for (j = 0; j < array.length; ++j) {
                //Originally ++count
                if (array[j] == array[i]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    // To calculate the median, you need to sort the array first
    // if array.length is odd, median in the middle number
    // if array.length is even, median is half of the sum of the middle numbers
    public static double calculateMedian(int[] array) {
        double median = 0.0;
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            //Cast to double to get the half if the size array is even
            median = (double) (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        } else {
            median = (double) array[array.length / 2];
        }
        return median;
    }

    public static double calculateStandardDeviation(int[] array) {
        double deviation = 0;
        double mean = calculateMean(array);
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += Math.pow(array[i] - mean, 2);
            System.out.println(sum);
        }
        deviation = Math.sqrt(sum / (array.length - 1));

        return deviation;
    }

}
