import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class ShowArrayAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> mylist = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            int i = sc.nextInt();
            mylist.add(i);
        }
        Collections.sort(mylist);
        System.out.println(mylist);
        int sum = 0;
        for (int i : mylist) {
            sum += i;
        }
        int length = mylist.size();
        double average = sum / length;
        System.out.println("Sum of the array : " + sum);
        System.out.println("Average of the array : " + average);

    }
}