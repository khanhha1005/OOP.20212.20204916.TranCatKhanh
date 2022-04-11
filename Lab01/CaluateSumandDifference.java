
import javax.swing.JOptionPane;

public class CaluateSumandDifference {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";
        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ", "Input the first numbers", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ", "Input the second numbers", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        String sum1 = String.valueOf(sum);
        double diff = num1 - num2;
        String diff1 = String.valueOf(diff);
        double product = num1 * num2;
        String product1 = String.valueOf(product);
        double quotient = num1 / num2;
        String quotient1 = String.valueOf(quotient);
        JOptionPane.showMessageDialog(null, "sum " + sum1, "Sum two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "difference " + diff1, "difference two numbers",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "product " + product1, "product two numbers",
                JOptionPane.INFORMATION_MESSAGE);
        if (num2 == 0) {
            String quo = "can not divide 0";
            JOptionPane.showMessageDialog(null, "quotient " + quo, "quotient two numbers",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(null, "quotient " + quotient1, "quotient two numbers",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}