import java.util.Scanner;
import java.lang.Math;

public class Solveequation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        if (n.equals("First")) {
            Double a = sc.nextDouble();
            Double b = sc.nextDouble();
            if (a == 0 & b == 0) {
                System.out.println(" infinity solution for x ");
            } else if (a == 0 & b != 0) {
                System.out.println("no solution for x");
            } else {
                System.out.println("solution for x is " + -b / a);
            }
        } else if (n.equals("Firsttwo")) {
            Double a11 = sc.nextDouble();
            Double a12 = sc.nextDouble();
            Double a21 = sc.nextDouble();
            Double a22 = sc.nextDouble();
            Double b1 = sc.nextDouble();
            Double b2 = sc.nextDouble();
            Double D = a11 * a22 - a21 * a12;
            Double D1 = b1 * a22 - b2 * a12;
            Double D2 = a11 * b2 - a21 * b1;
            if (D == 0) {
                System.out.println("no solution");
            } else {
                System.out.println("solution for x is " + D1 / D);
                System.out.println("solution for y is " + D2 / D);
            }
        } else if (n.equals("Second")) {
            Double a = sc.nextDouble();
            Double b = sc.nextDouble();
            Double c = sc.nextDouble();
            Double d = b * b - 4 * a * c;
            if (d == 0) {
                System.out.println("Solution for x1 and x2 is " + -b / (2 * a));
            } else if (d < 0) {
                System.out.println("no solution");
            } else {
                System.out.println("solution for x1 is " + (-b - Math.sqrt(d)) / (2 * a));
                System.out.println("solution for x2 is " + (-b - Math.sqrt(d)) / (2 * a));
            }
        }
    }
}