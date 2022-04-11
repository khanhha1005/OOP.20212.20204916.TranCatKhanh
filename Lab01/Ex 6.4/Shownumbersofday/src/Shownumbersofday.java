import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Shownumbersofday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine();

        String[] thirtydaysone = { "January", "Jan.", "1", "Jan", "March", "Mar.", "Mar", "3", "May", "5", "July",
                "Jul", "7", "Aug.", "Aug", "8", "August", "10", "Oct.", "Oct", "October",
                "December", "12", "Dec.", "Dec" };
        String[] thirtydays = { "April", "Apr.", "Apr", "4", "June", "Jun", "6", "Sept.", "Sep", "9", "September",
                "November", "Nov.", "Nov", "11" };
        String[] febuary = { "February", "Feb.", "2", "Feb" };
        String[] mon = { "January", "Jan.", "1", "Jan", "March", "Mar.", "Mar", "3", "May", "5", "July",
                "Jul", "7", "Aug.", "Aug", "8", "August", "10", "Oct.", "Oct", "October",
                "December", "12", "Dec.", "Dec", "April", "Apr.", "Apr", "4", "June", "Jun", "6", "Sept.", "Sep", "9",
                "September",
                "November", "Nov.", "Nov", "11", "February", "Feb.", "2", "Feb" };
        while (Arrays.asList(mon).contains(month) == false) {
            System.out.println("invalid month");
            String month1 = sc.nextLine();
            month = month1;
        }
        int year = sc.nextInt();
        while (year < 0) {
            System.out.println("invalid");
            System.out.println("Input again");
            int years = sc.nextInt();
            year = years;
        }
        if (year % 100 == 0 & year % 400 == 0 & Arrays.asList(febuary).contains(month)) {
            System.out.println("29 days ");
        } else if (Arrays.asList(febuary).contains(month)) {
            System.out.println("28 days ");
        }
        if (Arrays.asList(thirtydaysone).contains(month)) {
            System.out.println("31days");
        } else if (Arrays.asList(thirtydays).contains(month)) {
            System.out.println("30days");
        }
    }
}