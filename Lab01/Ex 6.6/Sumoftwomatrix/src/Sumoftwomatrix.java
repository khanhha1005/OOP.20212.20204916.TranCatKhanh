import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Sumoftwomatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("insert the number of rows of 2 matrix  ");
        int n = sc.nextInt();
        System.out.println("insert the number of columns of 2 matrix  ");
        int m = sc.nextInt();
        double a[][] = new double[n][m];
        System.out.println("Enter the elements of the matrix 1");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        double b[][] = new double[n][m];
        System.out.println("Enter the elements of the matrix 2 ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                b[i][j] = sc.nextInt();

        double c[][] = new double[n][m];
        System.out.println("The sum of two matrix is ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = a[i][j] + b[i][j]; // use - for subtraction
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}