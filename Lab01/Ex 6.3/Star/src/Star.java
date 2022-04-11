import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < n + 1; i++) {
            int k = find(i);
            int u = find(n) - k;
            for (int m = 0; m <= u / 2; m += 1) {
                System.out.print(" ");
            }
            for (int j = 1; j < k + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int find(int l) {
        int a = 1;
        int b = 2;
        int m = 0;
        for (int i = 0; i < l; i++) {
            if (a < b) {
                m = a * b - 1;
                a++;
            } else {
                m = a * b - 1;
                b++;
            }
        }
        return m;
    }
}